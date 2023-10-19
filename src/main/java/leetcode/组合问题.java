package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合问题 {
    public static void main(String[] args) {
        ZuHE zuHE=new ZuHE();
        zuHE.combine(4,2);
    }
}
class ZuHE {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combinHelper(n,k,1);
        return result;
    }

    private void combinHelper(int n,int k,int startIndex){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex; i<=n-(k-path.size())+1;i++){
            path.add(i);
            combinHelper(n,k,i+1);
            path.removeFirst();
        }
    }
}
