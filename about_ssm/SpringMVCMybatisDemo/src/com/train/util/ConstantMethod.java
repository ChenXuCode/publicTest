package com.train.util;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;

/**
 * 常量方法
 * 
 * @author lijie
 * 
 */
public class ConstantMethod {
    /**
     * 海关接口开关(true：开启；false：关闭)
     */
	 public static  final Boolean INTHGFLAG=true;
	 
	 
	 /*s*****************鑫和鑫丰*****************************/	
	/**
	 * 鑫丰集团ID（组织机构）
	 */
	 public static final String XFJTID="3b87d34279344945aa275984996f191e";
    /**
     * 鑫和码头公司id（组织机构）
     */
	 public static  final String XHMTID="8bc8dacc5ea64008b76f96f4c99a0c34";
    /**
     * 默认密码
     */
	 public static final String DEFAULTPWD="123456";
	 /**
	  * 珠海港鑫和码头 987uytrewqasdfghjkloiuytrewqawer
	  */
	 public static final String ZHGXTM="987uytrewqasdfghjkloiuytrewqawer";
	 /**
	  * 珠海高栏 67878trewqasdfghjkloiuytrewqawer
	  */
	 public static final String ZHGL="67878trewqasdfghjkloiuytrewqawer";
	 
	 /**
	  * 嘉信车队ID和名称 
	  */
	 public static final String JXCDID="34808e424dfc4691b5bd697ac0cec3a5";
	 public static final String JXCDNAME="嘉信港务";
	 /*s*****************港口费用*****************************/
	 	/**
	     * 其他(港口费用类型)
	     */
		 public static  final String OTHERID="8bc8d0005ea64008b76f96f4c99a0c34";
		 /**
		     * 其他(港口费用类型)
		     */
		public static  final String GKZXF="8bc8d0005ea69998b76f96f4c99a0c34";
		 /**
	     * feeCode(港口费用类型（港口装卸费）)
	     */
	public static  final String GKZXFCODE="A005";
	 /**
     * feeCode(港口费用类型（港口装卸费）)
     */
	public static  final String OTHERCODE="A099";
	  /**
     * 港口费
     * return map
     */
    public static final Map<String,String> getFeeTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(GKZXFCODE, "港口装卸费");
    	map.put(OTHERCODE, "其他");
    	return map;
    }
	/*s*****************有效标示*****************************/
	/**
	 * 无效
	 */
    public static final String FLAG_0="0";
    /**
     * 有效
     */
    public static final String FLAG_1="1";
    /**
     * 全部(用于查询)
     */
    public static final String FLAG_2="2";
    /**
     * 标识状态
     * return map
     */
    public static final Map<String,String> getUseFlagMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(FLAG_0, "无效");
    	map.put(FLAG_1, "有效");
    	map.put(FLAG_2, "全部");
    	return map;
    }
    /*e**********************************************/
    
	/*s*****************状态标示*****************************/
	/**
	 * A
	 */
    public static final String FLAG_A="A";
    /**
     * B
     */
    public static final String FLAG_B="B";
    /**
     * C
     */
    public static final String FLAG_C="C";
    /**
     * D
     */
    public static final String FLAG_D="D";
    /*e**********************************************/
    
    /*s*****************作业班别*****************************/
	 /**
	 * 作业工班
	 * 一班,二班，三班
	 */
   public static final String TASKORG_A1="A1";
   public static final String TASKORG_A2="A2";
   public static final String TASKORG_A3="A3";
   /**
    * 装卸班组
    * return map
    */
   public static final Map<String,String> getTaskOrgMap(){
   	@SuppressWarnings("unchecked")
	Map<String,String> map=ListOrderedMap.decorate(new HashMap<String,String>());
   	map.put(TASKORG_A1, "一班");
   	map.put(TASKORG_A2, "二班");
   	map.put(TASKORG_A3, "三班");
   	return map;
   }
   /*s*****************作业班组*****************************/
   public static final String TASKORG_1="1";
   public static final String TASKORG_2="2";
   public static final String TASKORG_3="3";
   /**
    * 加水班组
    * return map
    */
   public static final Map<String,String> getTaskWaterOrgMap(){
   	@SuppressWarnings("unchecked")
	Map<String,String> map=ListOrderedMap.decorate(new HashMap<String,String>());
   	map.put(TASKORG_1, "一班");
   	map.put(TASKORG_2, "二班");
   	map.put(TASKORG_3, "三班");
   	return map;
   }
    /*s*****************作业票类型*****************************/
    /**
     * 作业票类型map
     * return map
     */
    public static final Map<String,String> getTicketTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(FLAG_A, "合同");
    	map.put(FLAG_B, "台班");
    	map.put(FLAG_C, "杂项");
    	return map;
    }
    /*e*********************************************/
    
    /*s*****************作业票录入状态*****************************/
    /**
     * 作业票录入状态map
     * return map
     */
    public static final Map<String,String> getTicketFlagMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put("0", "待理货录入");
    	map.put("1", "待理货确认");
    	map.put("2", "已理货确认");
    	map.put("5", "已实绩确认");
    	return map;
    }
    /*e*********************************************/
    
    /*s*****************作业票装卸出勤班别类型*****************************/
    /**
     * 作业票装卸出勤班别类型map
     * return map
     */
    public static final Map<String,String> getHandlingTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(FLAG_A, "白班");
    	//map.put(FLAG_B, "中班");
    	map.put(FLAG_C, "晚班");
    	return map;
    }
    /*e*********************************************/
    
    /*s*****************状态类型*****************************/
    /**
     * 未提交
     */
    public static final String STATUSFLAG_0="0";
    /**
     * 待审核
     */
    public static final String STATUSFLAG_1="1";
    /**
     * 审核中
     */
    public static final String STATUSFLAG_2="2";
    /**
     * 审核完成
     */
    public static final String STATUSFLAG_3="3";
    /**
     * 作废
     */
    public static final String STATUSFLAG_4="4";
    /*e**********************************************/
    
    /*s*****************合同类型*****************************/
    /**
     * 港口作业协议
     */
    public static final String CONTRACTTYPE_A="A";
    /**
     * 保税仓协议
     */
    public static final String CONTRACTTYPE_B="B";
    /**
     * 堆场租赁合同
     */
    public static final String CONTRACTTYPE_C="C";
    /**
     * 转运(加高)协议
     */
    public static final String CONTRACTTYPE_D="D";
    /**
     * 清仓清理合同
     */
    public static final String CONTRACTTYPE_E="E";
    /**
     * 车辆环保合同
     */
    public static final String CONTRACTTYPE_F="F";
    /**
     * 运营管理委托合同
     */
    public static final String CONTRACTTYPE_G="G";
    /**
     * 其它合同
     */
    public static final String CONTRACTTYPE_Z="Z";
    
    /**
     * 合同类型CONTRACTTYPE_A
     * return map
     */
    public static final Map<String,String> getContractTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(CONTRACTTYPE_A, "港口作业协议");
    	map.put(CONTRACTTYPE_B, "保税仓协议");
    	map.put(CONTRACTTYPE_C, "租赁合同");
    	map.put(CONTRACTTYPE_D, "转运(加高)合同");
    	map.put(CONTRACTTYPE_E, "清仓清理合同");
    	map.put(CONTRACTTYPE_F, "车辆环保合同");
    	map.put(CONTRACTTYPE_G, "运营管理委托合同");
    	map.put(CONTRACTTYPE_Z, "其它");
    	 return map;
    }
    /*e**********************************************/
   
    /*s*****************贸易类型*****************************/
    /**
     * 外贸
     */
    public static final String TRADETYPE_0="0";
    /**
     * 内贸
     */
    public static final String TRADETYPE_1="1";
    /**
     * 贸易类型map
     * return map
     */
    public static final Map<String,String> getTradeTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(TRADETYPE_0, "外贸");
    	map.put(TRADETYPE_1, "内贸");
    	 return map;
    }
    /*e**********************************************/
    
    /*s*****************进出口类型*****************************/
    /**
     * 进口
     */
    public static final String IMPORTTYPE_0="0";
    /**
     * 出口
     */
    public static final String IMPORTTYPE_1="1";
    /**
     * 进出口类型map
     * return map
     */
    public static final Map<String,String> getImportTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(TRADETYPE_0, "进口");
    	map.put(TRADETYPE_1, "出口");
    	 return map;
    }
    /*e**********************************************/
    
    /*s*****************船舶预报状态类型*****************************/
    /**
     * 未提交
     */
    public static final String YB0100="YB0100";
    /**
     * 已预报
     */
    public static final String YB0200="YB0200";
    /**
     * 抵港
     */
    public static final String YB0300="YB0300";
    /**
     * 开工
     */
    public static final String YB0310="YB0310";
    /**
     * 完工
     */
    public static final String YB0400="YB0400";
    /**
     * 离港
     */
    public static final String YB0500="YB0500";
    /**
     * 船舶预报状态类型map
     * return map
     */
    public static final Map<String,String> getForecastMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(YB0100, "未提交");
    	map.put(YB0200, "已预报");
    	map.put(YB0300, "抵港");
    	map.put(YB0310, "开工");
    	map.put(YB0400, "完工");
    	map.put(YB0500, "离港");
    	return map;
    }
    /*e**********************************************/
    
    /*s***************** 船舶预报 状态选择 **************/
    /**
     * （船舶预报 状态选择）1.单种状态。
     */
    public static final String BOATFORECASTPAGEFLAG_A="A";
    /**
     * （船舶预报 状态选择）1.包含状态：已预报；2.涉及页面：卸船委托书录入页面、抵港增加页面。
     */
    public static final String BOATFORECASTPAGEFLAG_B="B";
    /**
     * （船舶预报 状态选择）1.包含状态：在港；2.涉及页面：抵港登记页面。
     */
    public static final String BOATFORECASTPAGEFLAG_C="C";
    /**
     * （船舶预报 状态选择）1.包含状态：已预报、在港；2.涉及页面：抵港编辑页面。
     */
    public static final String BOATFORECASTPAGEFLAG_D="D";
    /**
     * （船舶预报 状态选择）1.包含状态：在港、开工、完工；2.涉及页面：加水签证、系解缆、杂项作业、工班水尺。
     */
    public static final String BOATFORECASTPAGEFLAG_E="E";
    /**
     * （船舶预报 状态选择）1.包含状态：>=单种状态；2.涉及页面：预报页面。
     */
    public static final String BOATFORECASTPAGEFLAG_F="F";
    /**
     * （船舶预报 状态选择）1.包含状态：已预报，在港、开工、完工；2卸船委托书
     */
    public static final String BOATFORECASTPAGEFLAG_G="G";
    /*e***************** 船舶预报 状态选择 **************/
    
    /*s*****************预报货物明细状态类型*****************************/
    /**
     * 预报
     */
    public static final String HW0100="HW0100";
    /**
     * 已办委托
     */
    public static final String HW0200="HW0200";
    /**
     * 开工
     */
    public static final String HW0300="HW0300";
    /**
     * 完货
     */
    public static final String HW0400="HW0400";
    /**
     * 清场
     */
    public static final String HW0500="HW0500";
    /**
     * 预报货物明细状态类型map
     * return map
     */
    public static final Map<String,String> getItemFinishFlagMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(HW0100, "预报");
    	map.put(HW0200, "已办委托");
    	map.put(HW0300, "开工");
    	map.put(HW0400, "完货");
    	map.put(HW0500, "清场");
    	return map;
    }
    /*e**********************************************/
    
    /*s*****************港口属性*****************************/
    /**
     * 干散货(港口属性)
     */
    public static final String PORTPROPERTY_A="A";
    /**
     * 件杂货(港口属性)
     */
    public static final String PORTPROPERTY_B="B";  
    /*e*****************港口属性*****************************/
    
    /*s*****************车型*****************************/
    /**
     * 小车车型
     */
    public static final String CARTYPE_A="A";   
    /**
     * 中车车型
     */
    public static final String CARTYPE_B="B";   
    /**
     * 大车车型
     */
    public static final String CARTYPE_C="C";
    
    /**
     * 车辆类型map
     * @return
     */
     public static final Map<String,String> getCarInfoCarTypemap(){
     	Map<String,String> map = new HashMap<String,String>();
     	map.put(CARTYPE_A, "自卸车");
     	map.put(CARTYPE_B, "铲车");
     	map.put(CARTYPE_C, "勾机");
     	return map;
     }
    /*e*****************车型*****************************/
    
    /*s*****************客户类型*****************************/
    /**
     * 货主(客户类型)
     */
    public static final String customType_A="A";
    /**
     * 货代(客户类型)
     */
    public static final String customType_B="B";
    /**
     * 船代(客户类型)
     */
    public static final String customType_C="C";
    /**
     * 船主(客户类型)
     */
    public static final String customType_D="D";
    /**
     * 商检(客户类型)
     */
    public static final String customType_E="E";
    /**
     * 边检(客户类型)
     */
    public static final String customType_F="F";
    /**
     * 海关(客户类型)
     */
    public static final String customType_G="G";
    /**
     * 海事(客户类型)
     */
    public static final String customType_H="H";
    /**
     * 银行(客户类型)
     */
    public static final String customType_I="I";
    /**
     * 其他(客户类型)
     */
    public static final String customType_Z="Z";
    
    /**
     * 客户属性map
     * @return
     */
    public static final Map<String,String> getCustomTypeMap(){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put(customType_A, "货主");
    	map.put(customType_B, "货代");
    	map.put(customType_C, "船代");
    	map.put(customType_D, "船主");
    	map.put(customType_E, "商检");
    	map.put(customType_F, "边检");
    	map.put(customType_G, "海关");
    	map.put(customType_H, "海事");
    	map.put(customType_I, "银行");
    	map.put(customType_Z, "其他");   	
    	return map;
    }
    /*e*****************客户类型*****************************/
    
    /*s*****************货物信息*****************************/
    /**
     * 大类(货物信息级别)
     */
    public static final String LEVEL_0="0";
    /**
     * 中类(货物信息级别)
     */
    public static final String LEVEL_1="1";  
    /**
     * 小类(货物信息级别)
     */
    public static final String LEVEL_2="2";
    
    /**
     * 货物信息级别Map
     * @return
     */
    public static final Map<String,String> getItemLevelMap(){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put( LEVEL_0, "大类");
    	map.put(LEVEL_1, "中类");
    	map.put(LEVEL_2, "小类");
    	return map;
    }
    /*e*****************货物信息*****************************/
    
    /*s*****************泊位生产类型*****************************/
    /**
     * 泊位生产类型（A）
     * 
     */
    public static final String   ManuType_A="A";
    /**
     * 泊位生产类型（B）
     * 
     */
    public static final String   ManuType_B="B";
    /**
     * 泊位生产类型（C）
     * 
     */
    public static final String   ManuType_C="C";
    
    /**
     * 生产类型
     * return map
     */
    public static final Map<String,String> getManuTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(ManuType_A, "A泊位生产类型");
    	map.put(ManuType_B, "B泊位生产类型");
    	map.put(ManuType_C, "C泊位生产类型");
    	 return map;
    }
    
    /*e*****************泊位生产类型*****************************/
    
    /*s*****************泊位结构类型*****************************/
    /**
     * 泊位结构类型（A）
     * 
     */
    public static final String  CONTRUCTTYPE_A="A";
    /**
     * 泊位结构类型（B）
     * 
     */
    public static final String   CONTRUCTTYPE_B="B";
    /**
     * 泊位结构类型（C）
     * 
     */
    public static final String   CONTRUCTTYPE_C="C";
    
    /**
     * 结构类型
     * return map
     */
    public static final Map<String,String> getContructTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(CONTRUCTTYPE_A, "AAA泊位结构类型");
    	map.put(CONTRUCTTYPE_B, "BBB泊位结构类型");
    	map.put(CONTRUCTTYPE_C, "CCC泊位结构类型");
    	 return map;
    }
    
    /*e*****************泊位结构类型*****************************/
    
    /*s*****************泊位服务类型*****************************/
    /**
     * 泊位服务类型（A）
     * 
     */
    public static final String SERVICETYPE_A="A";
    /**
     * 泊位服务类型（B）
     * 
     */
    public static final String   SERVICETYPE_B="B";
    /**
     * 泊位服务类型（C）
     * 
     */
    public static final String   SERVICETYPE_C="C";
    
    /**
     * 服务类型
     * return map
     */
    public static final Map<String,String> getServiceTpyeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(SERVICETYPE_A, "AAA服务类型");
    	map.put(SERVICETYPE_B, "BBB服务类型");
    	map.put(SERVICETYPE_C, "CCC服务类型");
    	 return map;
    }
    
    /*e*****************泊位服务类型*****************************/
    
    /*s*****************泊位岸壁机械种类*****************************/
    /**
     * 泊位岸壁机械种类（A）
     * 
     */
    public static final String MACHTYPE_A="A";
    /**
     * 泊位岸壁机械种类（B）
     * 
     */
    public static final String MACHTYPE_B="B";
    /**
     * 泊位岸壁机械种类型（C）
     * 
     */
    public static final String MACHTYPE_C="C";
    
    /**
     * 岸壁机械种类型
     * return map
     */
    public static final Map<String,String> getMachTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(MACHTYPE_A, "AAA泊位岸壁机械种类型");
    	map.put(MACHTYPE_B, "BBB泊位岸壁机械种类型");
    	map.put(MACHTYPE_C, "CCC泊位岸壁机械种类型");
    	 return map;
    }
    
    
    /*e*****************泊位岸壁机械种类*****************************/
    
    /*s*****************学历（员工表）degress**************/
    public static final String DEGRESS_A="A";// A:博士
    public static final String DEGRESS_B="B";// B 硕士
    public static final String DEGRESS_C="C";// C 本科
    public static final String DEGRESS_D="D";// D 大专
    public static final String DEGRESS_E="E";// E技工
    public static final String DEGRESS_F="F";// F初中
    public static final String DEGRESS_Z="Z";// G其他
    
    /**
     * 学历Map
     * @return
     */
    public static final Map<String,String> getSysEmployeeDegressMap(){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put(DEGRESS_A, "博士");
    	map.put(DEGRESS_B, "硕士");
    	map.put(DEGRESS_C, "本科");
    	map.put(DEGRESS_D, "大专");
    	map.put(DEGRESS_E, "技工");
    	map.put(DEGRESS_F, "初中");
    	map.put(DEGRESS_Z, "其他");
    	return map;
    }
    /*e***********************************************/
    
    /*s*****************（船舶信息表）船盖种类 coverType**************/
    public static final String COVERtYPE_A="A";// A:船盖种类A
    public static final String COVERtYPE_B="B";// B 船盖种类B
    public static final String COVERtYPE_C="C";// C 船盖种类C
  
    /**
     * 船盖coverType
     * return map
     */
    public static final Map<String,String> getCoverTypeMap(){
    	Map<String,String> map=new HashMap<String,String>();
    	map.put(COVERtYPE_A, "船盖种类A");
    	map.put(COVERtYPE_B, "船盖种类B");
    	map.put(COVERtYPE_C, "船盖种类c");
    	
    	 return map;
    }
    
}
