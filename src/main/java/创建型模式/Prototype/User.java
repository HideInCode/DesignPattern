package 创建型模式.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 1.深克隆浅克隆的区别.
 * 2.怎么实现深克隆.
 *
 */

public class User implements Cloneable, Serializable {

    private Date lastUpdateTime;
    
    private int id;

    private Student student;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Object clone = null;
//        try {
//            clone = super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return super.clone();
//    }


//深clone方案1,若引用是基本类型构成,克隆下引用
//    public Object deepClone1() {
//        创建型模式.Prototype.User user = null;
//        try{
//            user = (创建型模式.Prototype.User)super.clone();
//
//            //引用对象再次克隆,要保证应用的对象也是基本类型构成,不然就还要层层clone
//            user.student=this.student.clone();
//        }catch(CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }


    @Override
    protected Object clone() throws CloneNotSupportedException {

        User user = null;
        //深clone方案2(常用),clone对象实现实现序列化,先把对象写入流,在把流转成对象
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            user = (User) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setLastUpdateTime(new Date());
        user.setId(666);

        User clone = (User) user.clone();
        System.out.println(clone.getId());
        clone.setId(777);
        System.out.println(clone.getId());
        System.out.println(user.getLastUpdateTime());




    }
}
