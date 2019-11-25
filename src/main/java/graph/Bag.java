package graph;


import java.util.Iterator;

/**
 * 背包是一种不支持从中删除元素的集合数据类型——它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素（用例也可以检查背包是否为空或者获取背包中元素的数量）。
 * @Author: dj
 * @Date: 2019/10/31 23:51
 * @Version 1.0
 */
public class Bag<T> implements Iterable<T> {

    //背包中元素的数量
    private int TCount=0;
    //创建大小为1的原始数组
    private T[] a=(T[])new Object[10];

    //返回背包中元素的数量
    public int size(){
        return TCount;
    }

    //调整背包大小
    private void resize(int max){
        //创建中转数组，并把数组数据放入中转数组
        T[] temp=(T[]) new Object[max];
        for(int i=0;i<TCount;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    //添加元素到背包，如果背包放满，先调整背包大小
    public void add(T T){
        if(TCount==a.length){
            resize(a.length*2);
        }
        a[TCount]=T;
        TCount++;
    }

    @Override
    //支持迭代
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{
        private int i=TCount;
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public T next() {
            return a[--i];
        }
    }

}
