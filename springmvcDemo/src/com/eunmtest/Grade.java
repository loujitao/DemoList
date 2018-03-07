package com.eunmtest;

public enum Grade {
    A("100-90"){
        public  String  thisGrade(){
            return "优";
        }
    },//用“，”分开
    B("89-80"){
        public  String  thisGrade(){
            return "良";
        }
    },
    C("79-70"){
        public  String  thisGrade(){
            return "中";
        }
    },
    D("69-60"){
        public  String  thisGrade(){
            return "合格";
        }
    },
    E("59-0"){
        public  String  thisGrade(){
            return "差";
        }
    };//最后一个用；

    private  String  value;//枚举类的属性 可多个
    private   Grade(String value1){//枚举类型必须私有构造
        this.value=value1;
    }

    public  abstract String  thisGrade();//有抽象方法，必须给出实现

}
