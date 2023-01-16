package hello.core.singleton;

public class StatefulService {
    private int price; // 상태 유지 필드 원래 10000 -> 20000 으로 바꿔치기 당함

    public void order(String name,int price){
        System.out.println("name = " + name + "price = "+ price);
        this.price = price; // 여기가 문제!!
    }

    public int getPrice(){
        return price;
    }
}
