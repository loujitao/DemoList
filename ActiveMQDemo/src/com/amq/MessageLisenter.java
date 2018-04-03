package com.amq;

import com.casic.amq.domain.Produce;
import com.casic.iot.model.*;
import com.google.gson.Gson;

import javax.jms.*;

import java.util.List;

public class MessageLisenter implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        if(msg instanceof TextMessage){
            TextMessage textMessage = (TextMessage) msg;
            try {
                System.out.println(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        if(msg instanceof ObjectMessage){
            ObjectMessage objectMessage= (ObjectMessage) msg;
           // Gson gson=new Gson();
            try {
                com.casic.amq.domain.AMQObjectMessage pros =(com.casic.amq.domain.AMQObjectMessage) objectMessage.getObject();
                List<Produce> produces=pros.getProduces();
                for (Produce pro: produces ) {
                    String name = pro.getName();
                    String operate = pro.getOperate();
                    Object obj = pro.getT();
                    if (obj == null) continue;

                    if ("IotIot".equals(name)) {
                        Gson gson = new Gson();
                        IotIot iotIot = (IotIot) obj;
                        String str = gson.toJson(iotIot);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotIot + ";" + str);
                    } else if ("IotDevice".equals(name)) {
                        Gson gson = new Gson();
                        IotDevice iotDevice = (IotDevice) obj;
                        String str = gson.toJson(iotDevice);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotDevice + ";" + str);
                    } else if ("IotInstance".equals(name)) {
                        Gson gson = new Gson();
                        IotInstance iotInstance = (IotInstance) obj;
                        String str = gson.toJson(iotInstance);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotInstance + ";" + str);
                    } else if ("Instance".equals(name)) {
                        Gson gson = new Gson();
                        Instance instance = (Instance) obj;
                        String str = gson.toJson(instance);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + instance + ";" + str);
                    } else if ("IotIdentity".equals(name)) {
                        Gson gson = new Gson();
                        IotIdentity iotIdentity = (IotIdentity) obj;
                        String str = gson.toJson(iotIdentity);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotIdentity + ";" + str);
                    } else if ("IotDeviceType".equals(name)) {
                        Gson gson = new Gson();
                        IotDeviceType iotDeviceType = (IotDeviceType) obj;
                        String str = gson.toJson(iotDeviceType);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotDeviceType + ";" + str);
                    } else if ("IotDeviceGroup".equals(name)) {
                        Gson gson = new Gson();
                        IotDeviceGroup iotDeviceGroup = (IotDeviceGroup) obj;
                        String str = gson.toJson(iotDeviceGroup);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotDeviceGroup + ";" + str);
                    } else if ("IotCollectionPoint".equals(name)) {
                        Gson gson = new Gson();
                        IotCollectionPoint iotCollectionPoint = (IotCollectionPoint) obj;
                        String str = gson.toJson(iotCollectionPoint);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotCollectionPoint + ";" + str);
                    } else if ("IotSubjectDevInstance".equals(name)) {
                        Gson gson = new Gson();
                        IotSubjectDevInstance iotSubject = (IotSubjectDevInstance) obj;
                        String str = gson.toJson(iotSubject);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotSubject + ";" + str);
                    } else if ("IotSubject".equals(name)) {
                        Gson gson = new Gson();
                        IotSubject iotSubject = (IotSubject) obj;
                        String str = gson.toJson(iotSubject);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotSubject + ";" + str);
                    } else if ("IotEnumeRate".equals(name)) {
                        Gson gson = new Gson();
                        IotEnumeRate iotEnumeRate = (IotEnumeRate) obj;
                        String str = gson.toJson(iotEnumeRate);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotEnumeRate + ";" + str);
                    } else if ("IotCollPointIsMain".equals(name)) {
                        Gson gson = new Gson();
                        IotCollPointIsMain iotCollPointIsMain = (IotCollPointIsMain) obj;
                        String str = gson.toJson(iotCollPointIsMain);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + iotCollPointIsMain + ";" + str);
                    } else if ("Ldcode".equals(name)) {
                        Gson gson = new Gson();
                        Ldcode ldcode = (Ldcode) obj;
                        String str = gson.toJson(ldcode);
                        System.out.println("操作：" + operate + ";数据类型：" + name + "数据：" + ldcode + ";" + str);
                    } else {
                        Gson gson = new Gson();
                        String str = gson.toJson(obj);
                        System.out.println("找不到数据类型！" + str);
                    }
                }
                //System.out.println("message" + gson.toJson(pros));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

   /* private Object conver(Object a) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(a);
        out.close();
        System.out.println(baos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        return  in.readObject();
    }*/

}
