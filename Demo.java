package promise;

import com.wjj.promise.Promise;

public class Demo {
    public static void main(String[] args){
        System.out.println(111);
        Demo demo=new Demo();
//        demo.test(2,4);

        System.out.println(666);

    }

    public void test(int a,int b){
        new Promise.Builder().promiseHanler(executor -> {
            System.out.println(222);
            Thread.sleep(5000);
            return a * b;
        }).build().then(resolvedData -> {
            System.out.println(333);
            System.out.println(resolvedData);
            return (Integer)resolvedData+1;
        }).then(res2->{
            System.out.println(444);
            System.out.println(res2);
            //创建一个新的promise2并返回
            return new Promise.Builder().externalInput(res2).promiseHanler(executor -> {
                return (Integer)executor.getExternalInput()+2;
            }).build();
        }).then(res3->{
            System.out.println(5555);
            System.out.println(res3);
            return res3;
        });
    }
}
