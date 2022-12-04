package SecondTest;

public class Test {
    public static void main(String[] args){
        ChineseGardenDog a1=new ChineseGardenDog("1",8,'W',200);
        cat c1=new cat("2",9,'M',150);
        cat c2=new cat("3",10,'M',100);
        Customer C1=new Customer("Lee");
        MyAnimalShop myShop=new MyAnimalShop();
        myShop.balance=1000;
        myShop.list1.add(a1);
        myShop.list1.add(c1);
        myShop.getNewAnimal(c2);
        myShop.getNewCustomer(C1);
        myShop.close();
    }
}
