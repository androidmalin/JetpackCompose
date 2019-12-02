package com.example.jetpackcompose;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Function {

    /**
     * 例 1-1
     * 首先建立了一个“虚词”(NON_WORDS)的集合(包括冠词和其他起连接作用的词)， 然后实现了 wordFreq() 方法。
     * 方法中首先建立一个 Map 结构来容纳由单词和词频组成的键值对，接着构造了一个用来识别单词的正则表达式。
     * 接下来的大段篇幅逐一遍历所有找到的单词，将首次遇到的单词添入 Map 结构，将重复遇到的单词的出现次数加 1。
     * 对于提倡 以步进方式处理集合(如例中正则表达式的匹配结果)遍历的语言来说，这是司空见惯的 编码风格。
     */
    public class Words {
        private Set<String> NON_WORDS = new HashSet<String>() {{
            add("the");
            add("and");
            add("of");
            add("to");
            add("a");
            add("i");
            add("it");
            add("in");
            add("or");
            add("is");
            add("d");
            add("s");
            add("as");
            add("so");
            add("but");
            add("be");
        }};

        public Map wordFreq(String words) {
            TreeMap<String, Integer> wordMap = new TreeMap<>();
            Matcher m = Pattern.compile("\\w+").matcher(words);
            while (m.find()) {
                String word = m.group().toLowerCase();
                if (!NON_WORDS.contains(word)) {
                    if (wordMap.get(word) == null) {
                        wordMap.put(word, 1);
                    } else {
                        wordMap.put(word, wordMap.get(word) + 1);
                    }
                }
            }
            return wordMap;
        }


        /**
         * 我将正则表达式的匹配结果转换为 stream，更方便后续执行互相独立的 几项操作:
         * 将所有的单词条目转换为小写，滤除虚词，计算余下单词的词频。
         * 我把 regexToList() 方法经由 find() 产生的匹配结果集合转换成 stream，
         * 这是为了让后续的操 作能够像我们考虑问题的方式一样，做完一步再去做下一步。
         * 虽然将命令式风格的例 1-1 改为对集合进行三次循环遍历(第一遍把所有的单词变成小写，第二遍滤除虚词，第三遍 计算词频)
         * 也能达成目的，但这种写法的效率会惨不忍睹。
         * 例 1-1 在一个迭代块里完成三 项操作，这是牺牲了代码的清晰来换取执行性能。哪怕这种牺牲再稀松平常，我总是不情 愿的。
         */
        public Map wordFreq2(String words) {
            TreeMap<String, Integer> wordMap = new TreeMap<>();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                regexToList(words, "\\w+")
                        .stream()
                        .map(String::toLowerCase)
                        .filter(w -> !NON_WORDS.contains(w))
                        .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
            }
            return wordMap;
        }

        private List<String> regexToList(String words, String regex) {
            List<String> wordList = new ArrayList<>();
            Matcher m = Pattern.compile(regex).matcher(words);
            while (m.find()) wordList.add(m.group());
            return wordList;
        }
    }


    /**
     * 在本例中，我为输入字符串制作了一个添加了索引的版本。
     * Scala 的 zip() 方法将(从 0 到 输入字符串长度值的)数字集合与 String 对象中所含字符的集合对位结合，组成一个新 的、由数字和字符对构成的集合。
     * 例如当输入字符串为 zabycdxx 时，indexedInput 将取值 为Vector ((0,z), (1,a), (2,b), (3,y), (4,c), (5,d), (6,x), (7,x))。
     * zip方法得名于 它像拉链(zipper)一样让两个集合对齐咬合在一起。
     * 准备好索引集合之后，我使用 Scala 的 for comprehension 首先查看待搜索字符的集合，然后取出索引集合中的索引字符对。
     * 由于 Scala 允许快捷访问集合的元素，所以我可以直接将当前搜索的字符与集合的第二个元素进行比较((if (char == pair._2))))。
     * 如果两个字符相同，那么返回索引字符对的索引部分 (pair._1)。
     * null的存在是 Java 语言的一大混乱来源:它到底是一个有效的返回值，还是表明返回值 缺失了?
     * 包括 Scala 在内的很多函数式语言通过 Option 类来避免这种语义上的含混，其取值要么是表示没有返回值的 None，
     * 要么是容纳了返回值的 Some。因为例 1-5 的需求只要求找到第一处匹配，所以我返回了结果集合的第一个元素 result.head。
     */
    public void sss() {
//        def firstIndexOfAny(input : String, searchChars : Seq[Char]) : Option[Int] = { def indexedInput = (0 until input.length).zip(input)
//        val result = for (pair <- indexedInput;
//        char <- searchChars;
//        if (char == pair._2)) yield (pair._1) if (result.isEmpty)
//            None
//        else
//            Some(result.head)
//        }
    }

    public class TheCompanyProcess {
        public String cleanNames(List<String> listOfNames) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < listOfNames.size(); i++) {
                if (listOfNames.get(i).length() > 1) {
                    result.append(capitalizeString(listOfNames.get(i))).append(",");
                }
            }
            return result.substring(0, result.length() - 1);
        }

        public String capitalizeString(String s) {
            return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
        }
    }

    public class Java8 {

        /**
         * 用 collect() 方法取代了 reduce()，原因是它操作 Java 的 String 类的效率更高;
         * collect() 是 Java 8 针对某些情形而提供的 reduce() 的特殊实现。
         * 除了这一点点差别，上 面的代码与例 2-3 的 Scala 实现极其相似
         */
        public String cleanNames(List<String> names) {
            if (names == null) return "";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return names
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(name -> name.length() > 1)
                        .map(this::capitalize)
                        .collect(Collectors.joining(","));
            }
            return null;
        }

        private String capitalize(String e) {
            return e.substring(0, 1).toUpperCase() + e.substring(1, e.length());
        }
    }
}
