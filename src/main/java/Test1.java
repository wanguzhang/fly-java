/**
 * @author 张攀钦
 * @date 2020-05-18-09:46
 */
public class Test1 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                while (true){
//                    System.out.println(1111);
                }
            }).start();
        }

    }
}
