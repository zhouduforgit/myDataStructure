#### /home/zhoudu/o2o
if [ $# -gt 7 -o $# -lt 6 ]
then
  echo Usage: $0 '<oraid/pw> <begin_date> <end_date><sect_no><usr><type><store_no>(可选项月汇总时不填)'
  exit 1
fi

oraid=$1
begin_date=$2
end_date=$3
sect_no=$4
usr=$5
type=$6
store_no=$7
 if [ "$store_no" ==  "0" ]
   then
     sqlstrc="--"
     sqlstrf="--"
   else
      sqlstrc=" and c.store_no in  ($store_no)"

      sqlstrf=" and f.store_no in  ($store_no)"
 fi

get_daily(){

sqlplus -s $oraid << !!

set   space      1
set   pages      50000
set   linesize   280
set   term       on
SET colsep ';'

column work_date  				format a10        heading 日期
column store_no   				format 990        heading 店
column usr        				format a4         heading 采购
column item_no    				format 9999999    heading 货号
column item_name  				format a33        heading 品名
column status     				format 90         heading 状态
column sup_no     				format 999999     heading 厂编
column sup_name   				format a50        heading 厂名
column sales      				format 9999990.90 heading 销量
column sales_amnt 				format 999999990.90 heading 业绩
column prof_per   				format 9999990.90 heading 毛利额
column name       				format a30        heading 渠道
column PROMOTION_NO       format 9999       heading 档期
column PROM_CLASS       	format 99         heading 级别
column PROM_LEVEL       	format 99         heading 价别


select substr(a.usr,5,4)  				 			  						usr,
       c.store_no                         						store_no,
       nvl(e.sup_no,a.sup_no)             						sup_no,
       g.company_name					  				  						sup_name,
       c.item_no                          						item_no,
       a.name                             						item_name,
       nvl(e.status,a.status)																				status,
       to_char(c.work_date,'yyyy-mm-dd')  						work_date,
       c.qty                              						sales,
       c.amount                           						sales_amnt,
       c.prof_amnt                                    prof_per,
       --decode(c.amount,0,0,c.prof_amnt/c.amount)*100  prof_per,
       d.name   																			name,
       c.PROMOTION_NO,
       c.PROM_CLASS,
       c.PROM_LEVEL
from items             a,
     o2o_sales_daily   c,
     store_items       e,
     o2o_supplier      d,
     supplier          g,
     groups            h
where c.item_no   = a.item_no
  and a.grp_no = h.grp_no
  and c.o2o_sup_no = d.o2o_sup_no
  and nvl(e.sup_no,a.sup_no) = g.sup_no
  and c.item_no   = e.item_no(+)
  and c.store_no  = e.store_no(+)
  and c.work_date >= to_date($begin_date,'yyyymmdd')
    $sqlstrc
   and c.work_date <= to_date($end_date,'yyyymmdd')
   and h.section_no = decode($sect_no,0,h.section_no,$sect_no)
   and ( (substr(user,5,4) = 'QA04' and h.section_no in (select section_no from sections where division_no in (3,6) ) ) or substr(user,5,4) <> 'QA04' )
   and substr(a.usr,5,4) = decode('$usr',0,substr(a.usr,5,4),'$usr')
   --and d.o2o_sup_no in (10035,10044,10061,10069,10064,10070,10059,10072,10062,10025)
union
select substr(a.usr,5,4)  				 			  usr,
       f.store_no                         store_no,
       nvl(e.sup_no,a.sup_no)             sup_no,
       g.company_name					  				  sup_name,
       f.item_no                          item_no,
       a.name                             item_name,
       nvl(e.status,a.status)														status,
       to_char(f.work_date,'yyyy-mm-dd')  work_date,
       (f.qty-nvl(c.qty,0))                      sales,
       (f.AMOUNT-nvl(c.amount,0))                sales_amnt,
       f.PROF_AMNT-nvl(c.PROF_AMNT,0)           prof_per,
       --decode((f.AMOUNT-nvl(c.amount,0)),0,0,(f.PROF_AMNT-nvl(c.PROF_AMNT,0))/(f.AMOUNT-nvl(c.amount,0)))*100  prof_per,
       '线下'   													name,
       f.PROMOTION_NO,
       f.PROM_CLASS,
       f.PROM_LEVEL
from items             a,
     (select WORK_DATE,
             STORE_NO,
             ITEM_NO,
             sum(QTY) QTY,
             sum(PROF_AMNT) PROF_AMNT,
             sum(AMOUNT) AMOUNT
      from o2o_sales_daily
      where work_date >= to_date($begin_date,'yyyymmdd')
        and work_date <= to_date($end_date,'yyyymmdd')
      group by WORK_DATE,STORE_NO,ITEM_NO)   c,
     store_items       e,
     supplier          g,
     sales_daily			 f,
     groups            h
where f.item_no   = a.item_no
  and nvl(e.sup_no,a.sup_no) = g.sup_no
  and f.work_date = c.work_date(+)
  and f.store_no = c.store_no(+)
  and f.item_no = c.item_no(+)
  and a.grp_no = h.grp_no
  and f.item_no   = e.item_no(+)
  and f.store_no  = e.store_no(+)
  and f.work_date >= to_date($begin_date,'yyyymmdd')
  and f.work_date <= to_date($end_date,'yyyymmdd')
    $sqlstrf
   and h.section_no = decode($sect_no,0,h.section_no,$sect_no)
   and ( (substr(user,5,4) = 'QA04' and h.section_no in (select section_no from sections where division_no in (3,6) ) ) or substr(user,5,4) <> 'QA04' )
   and substr(a.usr,5,4) = decode('$usr',0,substr(a.usr,5,4),'$usr')
order by 12,8,1,2,5;

exit
!!
}

get_mon(){

sqlplus -s $oraid << !!

set   space      1
set   pages      50000
set   linesize   280
set   term       on
SET colsep ';'

column work_date  format a10        heading 日期
column store_no   format 990        heading 店
column usr        format a4         heading 采购
column item_no    format 9999999    heading 货号
column item_name  format a33        heading 品名
column sup_no     format 999999     heading 厂编
column sup_name   format a50        heading 厂名
column sales      format 9999990.90 heading 销量
column sales_amnt format 999999990.90 heading 业绩
column prof_per   format 9999990.90 heading 毛利额
column name       format a30        heading 渠道

select substr(a.usr,5,4)  				 			  usr,
       --c.store_no                         store_no,
       nvl(e.sup_no,a.sup_no)             sup_no,
       g.company_name					  				  sup_name,
       c.item_no                          item_no,
       a.name                             item_name,
       --nvl(e.status,a.status)														status,
       to_char(c.work_date,'yyyymm')      work_date,
       sum(c.qty)                         sales,
       sum(c.amount)                      sales_amnt,
       sum(c.prof_amnt)          prof_per,
       --decode(sum(c.amount),0,0,sum(c.prof_amnt)/sum(c.amount))*100  prof_per,
       d.name   													name
from items             a,
     o2o_sales_daily   c,
     store_items       e,
     o2o_supplier      d,
     supplier          g,
     groups            h
where c.item_no   = a.item_no
  and a.grp_no = h.grp_no
  and c.o2o_sup_no = d.o2o_sup_no
  and nvl(e.sup_no,a.sup_no) = g.sup_no
  and c.item_no   = e.item_no(+)
  and c.store_no  = e.store_no(+)
  and c.work_date >= to_date($begin_date,'yyyymmdd')
  and c.work_date <= to_date($end_date,'yyyymmdd')
  -- and c.store_no = 1
  and h.section_no = decode($sect_no,0,h.section_no,$sect_no)
  and ( (substr(user,5,4) = 'QA04' and h.section_no in (select section_no from sections where division_no in (3,6) ) ) or substr(user,5,4) <> 'QA04' )
  and substr(a.usr,5,4) = decode('$usr',0,substr(a.usr,5,4),'$usr')
  --and d.o2o_sup_no in (10035,10044,10061,10069,10064,10070,10059,10072,10062,10025)
group by substr(a.usr,5,4),
         --c.store_no,
         nvl(e.sup_no,a.sup_no),
         g.company_name,
         c.item_no,
         a.name,
         --nvl(e.status,a.status),
         d.name,
         to_char(c.work_date,'yyyymm')
union
select substr(a.usr,5,4)  				 			  usr,
       --f.store_no                         store_no,
       nvl(e.sup_no,a.sup_no)             sup_no,
       g.company_name					  				  sup_name,
       f.item_no                          item_no,
       a.name                             item_name,
       --nvl(e.status,a.status)														status,
       to_char(f.work_date,'yyyymm')      work_date,
       sum(f.qty-nvl(c.qty,0))                   sales,
       sum(f.AMOUNT-nvl(c.amount,0))             sales_amnt,
       sum(f.PROF_AMNT-nvl(c.PROF_AMNT,0))  prof_per,
       --decode(sum(f.AMOUNT-nvl(c.amount,0)),0,0,sum(f.PROF_AMNT-nvl(c.PROF_AMNT,0))/sum(f.AMOUNT-nvl(c.amount,0)))*100  prof_per,
       '线下'   													name
from items             a,
     (select WORK_DATE,
             STORE_NO,
             ITEM_NO,
             sum(QTY) QTY,
             sum(PROF_AMNT) PROF_AMNT,
             sum(AMOUNT) AMOUNT
      from o2o_sales_daily
      where work_date >= to_date($begin_date,'yyyymmdd')
        and work_date <= to_date($end_date,'yyyymmdd')
      group by WORK_DATE,STORE_NO,ITEM_NO)   c,
     store_items       e,
     supplier          g,
     sales_daily			 f,
     groups            h
where f.item_no   = a.item_no
  and nvl(e.sup_no,a.sup_no) = g.sup_no
  and f.work_date = c.work_date(+)
  and f.store_no = c.store_no(+)
  and f.item_no = c.item_no(+)
  and a.grp_no = h.grp_no
  and f.item_no   = e.item_no(+)
  and f.store_no  = e.store_no(+)
  --and f.store_no = 1
  and f.work_date >= to_date($begin_date,'yyyymmdd')
  and f.work_date <= to_date($end_date,'yyyymmdd')
  and h.section_no = decode($sect_no,0,h.section_no,$sect_no)
  and ( (substr(user,5,4) = 'QA04' and h.section_no in (select section_no from sections where division_no in (3,6) ) ) or substr(user,5,4) <> 'QA04' )
  and substr(a.usr,5,4) = decode('$usr',0,substr(a.usr,5,4),'$usr')
group by substr(a.usr,5,4),
         --f.store_no,
         nvl(e.sup_no,a.sup_no),
         g.company_name,
         f.item_no,
         a.name,
         --nvl(e.status,a.status),
         to_char(f.work_date,'yyyymm')
order by 10,6,1,4;

exit
!!
}

if [ $type -eq 0 ]
then
	get_mon $oraid$ $begin_date $end_date $sect_no $usr $store_no
fi

if [ $type -eq 1 ]
then
	get_daily $oraid$ $begin_date $end_date $sect_no $usr $store_no
fi

