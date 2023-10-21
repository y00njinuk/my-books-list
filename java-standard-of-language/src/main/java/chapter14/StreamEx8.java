package chapter14;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamEx8 {
    public static void main(String[] args) {
        StudentInfo[] stuArr = {
                new StudentInfo("나자바", true, 1, 1, 300),
                new StudentInfo("김지미", false, 1, 1, 250),
                new StudentInfo("김자바", true, 1, 1, 200),
                new StudentInfo("이지미", false, 1, 2, 150),
                new StudentInfo("남자바", true, 1, 2, 100),
                new StudentInfo("안지미", false, 1, 2, 50),
                new StudentInfo("황지미", false, 1, 3, 100),
                new StudentInfo("강지미", false, 1, 3, 150),
                new StudentInfo("이자바", true, 1, 3, 200),

                new StudentInfo("나자바", true, 2, 1, 300),
                new StudentInfo("김지미", false, 2, 1, 250),
                new StudentInfo("김자바", true, 2, 1, 200),
                new StudentInfo("이지미", false, 2, 2, 150),
                new StudentInfo("남자바", true, 2, 2, 100),
                new StudentInfo("안지미", false, 2, 2, 50),
                new StudentInfo("황지미", false, 2, 3, 100),
                new StudentInfo("강지미", false, 2, 3, 150),
                new StudentInfo("이자바", true, 2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<StudentInfo>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(StudentInfo::getBan));

        for(List<StudentInfo> ban: stuByBan.values()) {
            for(StudentInfo s: ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<StudentInfo.Level, List<StudentInfo>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                    if(s.getScore() >= 200) return StudentInfo.Level.HIGH;
                    else if(s.getScore() >= 100) return StudentInfo.Level.MID;
                    else return StudentInfo.Level.LOW;
                }));

        TreeSet<StudentInfo.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(StudentInfo.Level key: keySet) {
            System.out.println("["+key+"]");
            for(StudentInfo s: stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화+통계(성적별학생수)%n");
        Map<StudentInfo.Level, Long> stuCntbyLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                    if(s.getScore() >= 200) return StudentInfo.Level.HIGH;
                    else if(s.getScore() >= 100) return StudentInfo.Level.MID;
                    else return StudentInfo.Level.LOW;
                }, counting()));

        for(StudentInfo.Level key: stuCntbyLevel.keySet())
            System.out.printf("[%s]-%d명%n", key, stuCntbyLevel.get(key));

        System.out.printf("%n5. 다중그룹화+통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, StudentInfo>> topStuByHakAndBan =
                Stream.of(stuArr).collect(
                        groupingBy(StudentInfo::getHak,
                                groupingBy(StudentInfo::getBan,
                                        collectingAndThen(maxBy(
                                                Comparator.comparingInt(StudentInfo::getScore)),
                                                Optional::get))));

        for(Map<Integer, StudentInfo> ban: topStuByHakAndBan.values())
            for(StudentInfo s: ban.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화+통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<StudentInfo.Level>> stuByScoreGroup =
                Stream.of(stuArr).collect(
                        groupingBy(s->s.getHak()+"-"+s.getBan(),
                                mapping(s -> {
                                    if(s.getScore() >= 200) return StudentInfo.Level.HIGH;
                                    else if(s.getScore() >= 100) return StudentInfo.Level.MID;
                                    else return StudentInfo.Level.LOW;
                                }, toSet())));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key: keySet2) {
            System.out.println("["+key+"]" + stuByScoreGroup.get(key));
        }
    }
}
