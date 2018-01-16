package desperado.admin.user.domain;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-12.
 */

public class UserResult extends Result {

    private List<User> list = new ArrayList<>();

    public void addUser(User user) {
        if (user != null) {
            list.add(user);
        }
    }

    public void addUsers(List<User> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<User> getUsers() {
        return list;
    }

    public static class User {

        private String id;

        private String name;

        private String sex;

        private int age;

        private String tel;

        private String title;

        private String titleId;

        private String account;

        private String password;

        private String departmentId;

        private String consultingRoomId;

        private String titleName;

        private String departmentName;

        private String consultingRoomName;

        public String getTitleName() {
            return titleName;
        }

        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getConsultingRoomName() {
            return consultingRoomName;
        }

        public void setConsultingRoomName(String consultingRoomName) {
            this.consultingRoomName = consultingRoomName;
        }

        public User(String id, String name, String sex, int i, String tel, String titleId,
                    String departmentId, String consultingRoomId) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = i;
            this.tel = tel;
            this.titleId = titleId;
            this.departmentId = departmentId;
            this.consultingRoomId = consultingRoomId;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            byte[] st = Base64.getEncoder().encode(password.getBytes());
            return new String(st, Charset.forName("UTF-8"));
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTitleId() {
            return titleId;
        }

        public void setTitleId(String titleId) {
            this.titleId = titleId;
        }

        public User() {
        }

        public User(String name, String sex, int age, String tel, String titleId, String account, String password,
                    String departmentId, String consultingRoomId) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.tel = tel;
            this.titleId = titleId;
            this.account = account;
            this.password = password;
            this.departmentId = departmentId;
            this.consultingRoomId = consultingRoomId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getConsultingRoomId() {
            return consultingRoomId;
        }

        public void setConsultingRoomId(String consultingRoomId) {
            this.consultingRoomId = consultingRoomId;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


    }
}
