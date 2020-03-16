package com.jue.java.learntest.tooffer.solution33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] test = {3, 32, 321};
        int[] test1 = {3, 5, 1, 4, 2};
        int[] test2 = {3334, 3, 3333332};
        System.out.println((new Solution()).PrintMinNumber(test2));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers.length <= 0) {
            return "";
        }
        String result = "";
        ArrayList<ArrayList<Integer>> min = new ArrayList<>();
        ArrayList<ArrayList<Integer>> other = new ArrayList<>();
        int minNumber = Integer.MAX_VALUE;
        for (int n : numbers) {
            ArrayList<Integer> temp = new ArrayList<>();
            do {
                temp.add(0, n % 10);
            } while ((n = n / 10) > 0);
            if (temp.get(0) > minNumber) {
                other.add(temp);
            } else if (temp.get(0) == minNumber) {
                min.add(temp);
            } else {
                minNumber = temp.get(0);
                other.addAll(min);
                min = new ArrayList<>();
                min.add(temp);
            }
        }
        while (min.size() + other.size() > 0) {
            //如果最小数没有数据
            if (min.size() == 0) {
                minNumber = other.get(0).get(0);
                for (ArrayList<Integer> o : other) {
                    if (o.get(0) < minNumber) {
                        minNumber = o.get(0);
                        min = new ArrayList<>();
                    }
                    min.add(o);
                }
                other.removeAll(min);
            } else if (min.size() == 1) {
                for (Integer m : min.get(0)) {
                    result += m;
                }
                min.remove(0);
            } else {
                minNumber = min.get(0).get(0);
                int index = 0;
                ArrayList<ArrayList<Integer>> minTemp = new ArrayList<>();
                while (minTemp.isEmpty()) {
                    //用于计算是否有重复
                    int count = 0;
                    for (ArrayList<Integer> m : min) {
                        //如果空指针
                        if (m.size() <= index) {
                            if (m.get(m.size() - 1) == minNumber) {
                                count++;
                                minTemp.add(m);
                            }
                        } else if (m.get(index) == minNumber) {
                            minTemp.add(m);
                        } else if (m.get(index) < minNumber) {
                            minTemp = new ArrayList<>();
                            minNumber = m.get(index);
                            minTemp.add(m);
                        }
                    }
                    if (minTemp.size() == 1 || min.size() == count) {
                        break;
                    }
                    if (minTemp.size() > 1) {
                        //开始递归
                        index++;
                        min.removeAll(minTemp);
                        other.addAll(min);
                        min = minTemp;
                        minTemp = new ArrayList<>();
                    }
                }
                for (Integer m : minTemp.get(0)) {
                    result += m;
                }
                min.remove(minTemp.get(0));
                minTemp.remove(0);
                min.addAll(minTemp);
            }
        }
        return result;
    }
}

class SolutionPerfect {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int numofzero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numofzero++;
                continue;
            }
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer num : list) {
            builder.append(num);
        }
        for (int i = 0; i < numofzero; i++) {
            builder.insert(1, "0");
        }
        return builder.toString();
    }
}