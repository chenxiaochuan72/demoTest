//package 设计模式.结构型模式.组合模式.service.engine;
//
//import 设计模式.结构型模式.组合模式.service.logic.LogicFilter;
//import 设计模式.结构型模式.组合模式.service.logic.impl.UserAgeFilter;
//import 设计模式.结构型模式.组合模式.service.logic.impl.UserGenderFilter;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// *  决策节点配置
// */
//public class EngineConfig {
//    static Map<String, LogicFilter> logicFilterMap;
//    static {
//        logicFilterMap = new ConcurrentHashMap<>();
//        logicFilterMap.put("userAge", new UserAgeFilter());
//        logicFilterMap.put("userGender", new UserGenderFilter());
//    }
//    public Map<String, LogicFilter> getLogicFilterMap() {
//        return logicFilterMap;
//    }
//    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
//        this.logicFilterMap = logicFilterMap;
//    }
//}
