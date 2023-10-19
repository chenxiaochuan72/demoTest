//package 设计模式.结构型模式.组合模式.service.engine.impl;
//
//import 设计模式.结构型模式.组合模式.model.aggregates.TreeRich;
//import 设计模式.结构型模式.组合模式.model.vo.EngineResult;
//import 设计模式.结构型模式.组合模式.model.vo.TreeNode;
//import 设计模式.结构型模式.组合模式.service.engine.EngineBase;
//
//import java.util.Map;
//
//public class TreeEngineHandle extends EngineBase {
//    @Override
//    public EngineResult process(Long treeId, String userId, TreeRich
//            treeRich, Map<String, String> decisionMatter) {
//// 决策流程
//        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId,
//                decisionMatter);
//// 决策结果
//        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
//    }
//}
