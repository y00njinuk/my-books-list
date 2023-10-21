package chapter14;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

class StudentInfo {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public StudentInfo(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }
    public String getName() { return name; }
    public boolean isMale() { return isMale; }
    public int getHak() { return hak; }
    public int getBan() { return ban; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", hak=" + hak +
                ", ban=" + ban +
                ", score=" + score +
                '}';
    }
    enum Level { HIGH, MID, LOW }
}

public class StreamEx7 {
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

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<StudentInfo>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentInfo::isMale));

        List<StudentInfo> maleStudent = stuBySex.get(true);
        List<StudentInfo> femaleStudent = stuBySex.get(false);

        for(StudentInfo s: maleStudent) System.out.println(s);
        for(StudentInfo s: femaleStudent) System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentInfo::isMale, counting()));

        System.out.println("남학생수:"+stuNumBySex.get(true));
        System.out.println("여학생수:"+stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<StudentInfo>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentInfo::isMale,
                        maxBy(comparingInt(StudentInfo::getScore))));

        System.out.println("남학생1등:"+topScoreBySex.get(true));
        System.out.println("여학생1등:"+topScoreBySex.get(false));

        Map<Boolean, StudentInfo> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(StudentInfo::isMale,
                        collectingAndThen(maxBy(comparingInt(StudentInfo::getScore)), Optional::get)));

        System.out.println("남학생1등:"+topScoreBySex2.get(true));
        System.out.println("여학생1등:"+topScoreBySex2.get(false));

        System.out.printf("%n4. 다중 분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean, Map<Boolean, List<StudentInfo>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(StudentInfo::isMale, partitioningBy(s->s.getScore()<=100)));

        List<StudentInfo> failedMaleStu = failedStuBySex.get(true).get(true);
        List<StudentInfo> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(StudentInfo s: failedMaleStu) System.out.println(s);
        for(StudentInfo s: failedFemaleStu) System.out.println(s);
    }
}
