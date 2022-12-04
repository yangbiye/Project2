package SecondTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


abstract class Animal{
    public String name;
    public int age;
    public char gender;
    public double price;
    public Animal(){

    }
    public Animal(String name,int age,char gender,double price){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.price=price;
    }
    public abstract String toString();
}

class ChineseGardenDog extends Animal{
    public ChineseGardenDog(String name,int age,char gender,double price){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.price=price;
    }
    boolean isVaccinate;
    String getIsVaccinate(){
        if(this.isVaccinate) return "是";
        else return "否";
    }
    public double price=200;
    @Override
    public String toString(){
        String s="这只狗的信息：\n姓名："+this.name+"\n年龄："+this.age+"\n性别："+this.gender+"\n价格："+this.price+"\n是否注射疫苗"+this.getIsVaccinate();
        return s;
    }
}

class cat extends Animal{
    public cat(String name,int age,char gender,double price){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.price=price;
    }
    boolean isVaccinate;
    String getIsVaccinate(){
        if(this.isVaccinate) return "是";
        else return "否";
    }
    public double price=200;
    @Override
    public String toString(){
        String s="这只猫的信息：\n姓名："+this.name+"\n年龄："+this.age+"\n" +
                "性别："+this.gender+"\n价格："+this.price+"\n是否注射疫苗"+this.getIsVaccinate();
        return s;
    }
}

class Customer{
    public String name;
    public int comeCnt=0;
    public LocalDate time;
    public Customer(String name){
        this.name=name;
    }
    public LocalDate getTime(){
        return this.time;
    }
    @Override
    public String toString(){
        String s="该顾客的信息：\n姓名："+this.name+"\n到店次数："+this.comeCnt+"\n" +
                "最新到店时间："+this.getTime()+"\n";
        return s;
    }
}

interface AnimalShop{
    void getNewAnimal(Animal a);

    void getNewCustomer(Customer c);

    boolean isBusiness();
}

class MyAnimalShop implements AnimalShop{
    double balance;
    LocalDateTime dt=LocalDateTime.of(2022,12,4,6,0,0);
    double profit=0;
    public List<Animal>list1=new ArrayList();
    public List<Customer>list2=new ArrayList();
    boolean isOpen;
    @Override
    public void getNewAnimal(Animal a){
        list1.add(a);
        if(balance<a.price) throw new InsufficientBalanceException("余额不足");
        else balance-=a.price;
        profit-=a.price;
    }
    @Override
    public void getNewCustomer(Customer c){
        list2.add(c);
        c.comeCnt++;
        c.time=LocalDate.now();
    }
    public void sellAnimal(Animal a,Customer c){
        c.comeCnt++;
        c.time=LocalDate.now();
        System.out.println("出售的"+a.toString());
        if(!list1.remove(a)) throw new AnimalNotFoundException("没有这个动物");
        balance+=a.price;
        profit+=a.price;
    }
    @Override
    public boolean isBusiness(){
        if(this.isOpen) return true;
        else return false;
    }

    public void close(){
        if(dt.getHour()>=18){
            for (int i=0; i<list2.size(); i++) {
                Customer s = list2.get(i);
                System.out.println(s.toString());
            }
        }
        if(true){//测试时间到达之后关门的代码
            for (int i=0; i<list2.size(); i++) {
                Customer s = list2.get(i);
                System.out.println(s.toString());
            }
        }
        System.out.println("今天的盈利："+profit);
    }
}


class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(){
        super();
    }
    public AnimalNotFoundException(String message){
        super(message);
    }
}
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(){
        super();
    }
    public InsufficientBalanceException(String message){
        super(message);
    }
}

