package swea.tbd.n17433;

import java.util.HashMap;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private final static int CMD_INIT = 100;
    private final static int CMD_ADD = 200;
    private final static int CMD_REMOVE = 300;
    private final static int CMD_QUERY = 400;

    private final static UserSolution usersolution = new UserSolution();

    private static void String2Char(char[] buf, String str) {
        for (int k = 0; k < str.length(); ++k)
            buf[k] = str.charAt(k);
        buf[str.length()] = '\0';
    }
    private static boolean run(BufferedReader br) throws Exception {
        int q = Integer.parseInt(br.readLine());

        int id, grade, score;
        int cmd, ans, ret;
        boolean okay = false;

        for (int i = 0; i < q; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case CMD_INIT:
                    usersolution.init();
                    okay = true;
                    break;
                case CMD_ADD:
                    char[] gender = new char[7];
                    id = Integer.parseInt(st.nextToken());
                    grade = Integer.parseInt(st.nextToken());
                    String2Char(gender, st.nextToken());
                    score = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.add(id, grade, gender, score);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_REMOVE:
                    id = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.remove(id);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_QUERY:
                    int gradeCnt, genderCnt;
                    int[] gradeArr = new int[3];
                    char[][] genderArr = new char[2][7];
                    gradeCnt = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < gradeCnt; ++j) {
                        gradeArr[j] = Integer.parseInt(st.nextToken());
                    }
                    genderCnt = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < genderCnt; ++j) {
                        String2Char(genderArr[j], st.nextToken());
                    }
                    score = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.query(gradeCnt, gradeArr, genderCnt, genderArr, score);
                    if (ret != ans)
                        okay = false;
                    break;
                default:
                    okay = false;
                    break;
            }
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}
class Student {
    int id, grade, score;
    char gender;

    public Student(int id, int grade, int score, char gender) {
        super();
        this.id = id;
        this.grade = grade;
        this.score = score;
        this.gender = gender;
    }

    Student(int score) {
        this.score = score;
    }
}

class StudentManager {
    Student max, min;
    TreeMap<Student, Object> list = new TreeMap<Student, Object>((o1, o2) -> {
        if (o1.score == o2.score)
            return o1.id - o2.id;
        return o1.score - o2.score;
    });

    void addTree(Student student) {
        list.put(student, null);
        min = list.firstKey();
        max = list.lastKey();
    }

    void removeTree(Student student) {
        list.remove(student);
        if (list.isEmpty()) {
            min = null;
            max = null;
            return;
        }
        min = list.firstKey();
        max = list.lastKey();
    }
}

class UserSolution {
    HashMap<String, StudentManager> managerMap;
    HashMap<Integer, Student> studentMap;

    public void init() {
        managerMap = new HashMap<>();
        studentMap = new HashMap<>();
        managerMap.put("1f", new StudentManager());
        managerMap.put("2f", new StudentManager());
        managerMap.put("3f", new StudentManager());
        managerMap.put("1m", new StudentManager());
        managerMap.put("2m", new StudentManager());
        managerMap.put("3m", new StudentManager());
        return;
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        Student addStudent = new Student(mId, mGrade, mScore, mGender[0]);
        studentMap.put(mId, addStudent);
        StudentManager stMg = managerMap.get(mGrade + "" + mGender[0]);
        stMg.addTree(addStudent);
        return stMg.max.id;
    }

    public int remove(int mId) {
        Student rmStudent = studentMap.getOrDefault(mId, null);
        if (rmStudent == null)
            return 0;
        StudentManager stMg = managerMap.get(rmStudent.grade + "" + rmStudent.gender);
        stMg.removeTree(rmStudent);
        return stMg.min == null ? 0 : stMg.min.id;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        Student min = null;
        for (int i = 0; i < mGradeCnt; i++) {
            int g = mGrade[i];
            for (int j = 0; j < mGenderCnt; j++) {
                char gen = mGender[j][0];
                StudentManager stMg = managerMap.get(g + "" + gen);
                Student tmp = stMg.list.ceilingKey(new Student(mScore));
                if (tmp == null)
                    continue;
                if (min == null || min.score > tmp.score || (min.score == tmp.score && min.id > tmp.id)) {
                    min = tmp;
                }
            }
        }
        return min == null ? 0 : min.id;
    }
}
