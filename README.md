# 数据库课程--医院就诊系统模拟

### 目的

主要用来熟悉数据库表设计技巧.

### 系统概述

* 系统分为四个模块, 分别为:

 * 管理模块: 只有管理员才能进入的模块, 管理员通过这个模块录入数据.

 * 挂号模块: 只有护士才能进入的模块, 护士通过这个模块进行挂号操作.

 * 就诊模块: 只有医生才能进入的模块, 医生对已经他/她的号的病人进行就诊, 并且写病例开药.

 * 收费模块: 病人根据病例上的药单进行付款, 该模块只有护士才能操作.

 * 取药模块: 病人付款后才能取药, 只有护士能操作该模块.

* 总体图如下:

![](/截图/系统模块概述.png)

### 数据库设计

* 用例图

* 属性图

* E-R图

* 数据字典

> #### 用例图

* 管理员职责

![](/截图/管理员职责.png)

* 用户职责

![](/截图/用户职责.png)

> #### 属性图

* 职称

![](/截图/职称.png)

* 用户

![](/截图/用户.png)

* 门诊

![](/截图/门诊.png)

* 就诊室

![](/截图/就诊室.png)

* 药品

![](/截图/药品.png)

* 药方

![](/截图/药方.png)

* 病人信息

![](/截图/病人信息.png)

* 病例

![](/截图/病例.png)

* 挂号单

![](/截图/挂号单.png)

* 收费单

![](/截图/收费单.png)

> #### E-R图

![](/截图/E-R图.png)

> #### 数据字典

* 职称表(user_title)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :-----:  | :----:  | :----:  |
| id | unsigned bigint | 职称ID | 主键, 自增 |
| name | varchar(20) | 职称名字 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |


* 用户表(user)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| user_id | unsigned bigint | 用户ID | 主键, 自增 |
| user_name | char(20) | 用户名字 | 非空 |
| sex | char(2) | 性别 | 男或者女 |
| age | unsigned tinyint | 年龄 | 非空 |
| tel_phone | char(20) | 电话 | 无 |
| title_id | unsigned bigint | 职称 | 外键非空 |
| account | varchar(20) | 账号 | 唯一非空 |
| passwd | varchar(25) | 密码 | 非空 |
| consulting_room_id | unsigned bigint | 就诊室ID | 外键 |
| department_id | unsigned bigint | 部门D | 外键 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 门诊部表(department)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| department_id | unsigned bigint | 门诊ID| 主键, 自增 |
| department_name | varchar(20) | 门诊名字 | 非空 |
| counts | unsigned smallint | 门诊人数 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 就诊室表(consulting_room)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| consulting_room_id | unsigned bigint | 就诊室ID | 主键, 自增 |
| location | char(20) | 地点 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 药品(medicine)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| medicine_id | unsigned bigint | 药品ID | 主键, 自增 |
| medicine_name | varchar(35) | 药品名字 | 非空 |
| price | decimal(7, 2) | 价格 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 药方(medicine_list)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| medicine_id | unsigned bigint | 药品ID | 主键, 外键 |
| case_report_id | unsigned_bigint | 病例ID | 主键, 外键 |
| mount | unsigned_tinyint | 数量 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 病人信息(patient)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| patient_id | unsigned bigint | 病人ID | 主键, 自增 |
| patient_name | char(20) | 病人名字 | 非空 |
| id_card | char(20) | 身份证 | 非空 |
| sex | char(2) | 性别 | 男或者女 |
| age | unsigned tinyint | 年龄 | 非空 |
| tel_phone | char(20) | 电话 | 无 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 病例(case_report)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| case_report_id | unsigned bigint | 病例ID | 主键, 自增 |
| patient_id | unsigned bigint | 病人id | 主键, 外键 |
| description | varchar(250) | 病情描述 | 非空 |
| is_pay | unsigned_tinyint | 此次看病是否已经付款 1表示付款了 0表示未付款 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 挂号单(appointment)

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| appointment_id | unsigned bigint | 挂号单ID | 主键, 自增 |
| patient_id | unsigned bigint | 病人id | 主键, 外键 |
| consulting_date | datetime | 就诊时间 | 非空 |
| medicine_list_id | unsigned_bigint | 药品清单ID | 外键 |
| doctor_id | unsigned_bigint | 医生ID | 外键 |
| department_id | unsigned bigint | 门诊部id | 外键非空 |
| consulting_room_id | unsigned bigint | 就诊室ID | 外键非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

* 收费单

| 列名 | 数据类型 | 说明 | 约束 |
| :--------: | :--------: | :----: | :----:  |
| pay_list_id | unsigned bigint | 挂号单ID | 主键, 自增 |
| case_report_id | unsigned_bigint | 药品清单ID | 外键 |
| total_price | decimal(7, 2) | 总价 | 非空 |
| create | datetime | 创建时间 | 非空 |
| modified | datetime | 上次修改时间 | 无 |

### 系统实现

* 数据库使用的是``mysql``

* 基于``JavaEE``的``Servlet``原生``API``, ``Web``容器使用的是``Tomcat``.

* 以``Json``的格式返回给客户端.

> #### 缺陷

* 时间有限, 没有将管理员表与用户表分开.

* 时间有限, 代码没什么注释.

> #### 注意

* 管理员才能访问``/admin``开头的``URL``, 并且只能访问以``/admin``开头的``URL``.

* 必须登录后才能请求数据

> #### API一览

* 管理员

| URL | 方法 | 参数 | 说明 | 实例 |
| :--------: | :--------: | :----: | :----: | :----:  |
| /admin/users | GET | 无 | 查看所有用户 | 1 |
| /admin/user | GET | titleId(职称ID) | 查看特定职称的用户 | 2 |
| /admin/user/add | POST | name, sex, tel(电话), age(age > 18 && age < 150), account(账号), password, departmentId(部门ID), consultingRoomId(就诊室ID) | 添加用户 | 3 |
| /admin/user/delete | POST | id | 删除指定的用户 | 4 |
| /admin/user/update | POST | id, name, sex, tel(电话), age(age > 18 && age < 150), departmentId(部门ID), consultingRoomId(就诊室ID) | 修改用户信息 | 5 |
| /admin/titles | GET | 无 | 查看所有职称 | 6 |
| /admin/title | GET | id(职称ID) | 查看id对应的信息 | 7 |
| /admin/title/add | POST | title(职称名字) | 添加一个职称 | 8 |
| /admin/title/delete | POST | id | 删除一个职称 | 9 |
| /admin/title/update | POST | id, title | 修改职称信息 | 10 |
| /admin/medicines | GET | 无 | 查看所有药品信息 | 11 |
| /admin/medicine | GET | id | 查看id对应的药品信息 | 12 |
| /admin/medicine/add | POST | name, price | 添加药品 | 13 |
| /admin/medicine/delete | POST |　id | 删除药品 | 14 |
| /admin/medicine/update | POST | id, name, price | 修改药品 | 15 |
| /admin/departments | GET | 无 | 查看所有部门 | 16 |
| /admin/department | GET | id | 查看id对应的部门信息 | 17 |
| /admin/department/add | POST | name, counts(部门人数) | 添加部门 | 18 |
| /admin/department/delete | POST | id | 删除部门 | 19 |
| /admin/department/update | POST | id, name, counts | 修改部门信息 | 20 |
| /admin/consultingrooms | GET | 无 | 查看所有就诊室 | 21 |
| /admin/consultingroom | GET | id(部门ID) | 查看部门下的所有就诊室 | 22 |
| /admin/consultingroom/add | POST | departmentId, location | 添加部门 | 23 |
| /admin/consultingroom/delete | POST | id | 删除就诊室 | 24 |
| /admin/consultingroom/update | POST | id, departmentID, location | 修改就诊室 | 25 |

> 实例1

```json
{
    "list": [
        {
            "id": "1",
            "name": "瑟莉娜",
            "sex": "女",
            "age": 1,
            "tel": "15625199954",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "2",
            "name": "ronaldo",
            "sex": "男",
            "age": 26,
            "tel": "15625144544",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "4",
            "name": "啦啦",
            "sex": "女",
            "age": 28,
            "tel": "14573574685",
            "title": "护士",
            "titleId": "2",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "8",
            "name": "临时",
            "sex": "男",
            "age": 25,
            "tel": "12365456534",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "9",
            "name": "傻逼",
            "sex": "男",
            "age": 1,
            "tel": "15625145044",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "10",
            "name": "柳橙汁",
            "sex": "女",
            "age": 19,
            "tel": "12435645436",
            "title": "护士",
            "titleId": "2",
            "departmentId": "1",
            "consultingRoomId": "3",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-103"
        },
        {
            "id": "11",
            "name": "拉拉",
            "sex": "男",
            "age": 30,
            "tel": "17625342342",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例2

```json
{
    "list": [
        {
            "id": "1",
            "name": "瑟莉娜",
            "sex": "女",
            "age": 1,
            "tel": "15625199954",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "2",
            "name": "ronaldo",
            "sex": "男",
            "age": 26,
            "tel": "15625144544",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "8",
            "name": "临时",
            "sex": "男",
            "age": 25,
            "tel": "12365456534",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "9",
            "name": "傻逼",
            "sex": "男",
            "age": 1,
            "tel": "15625145044",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        },
        {
            "id": "11",
            "name": "拉拉",
            "sex": "男",
            "age": 30,
            "tel": "17625342342",
            "title": "医生",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例3

```json
{
    "list": [
        {
            "name": "test",
            "sex": "男",
            "age": 19,
            "tel": "15565872800",
            "titleId": "1",
            "account": "156251",
            "password": "123456789",
            "departmentId": "1",
            "consultingRoomId": "1"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例4

```json
{
    "list": [
        {
            "id": "13",
            "name": "test",
            "sex": "男",
            "age": 19,
            "tel": "15565872800",
            "titleId": "1"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例5

```json
{
    "list": [
        {
            "id": "2",
            "name": "test",
            "sex": "男",
            "age": 19,
            "tel": "15565872800",
            "titleId": "1",
            "departmentId": "1",
            "consultingRoomId": "1"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例6

```json
{
    "titles": [
        {
            "id": "1",
            "name": "医生"
        },
        {
            "id": "2",
            "name": "护士"
        },
        {
            "id": "3",
            "name": "管理员"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例7

```json
{
    "titles": [
        {
            "id": "2",
            "name": "护士"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例8

```json
{
    "titles": [
        {
            "name": "test"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例9

```json
{
    "titles": [
        {
            "id": "4",
            "name": "test"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例10

```json
{
    "titles": [
        {
            "id": "5",
            "name": "update"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例11

```json
{
    "list": [
        {
            "id": "1",
            "name": "脑白金",
            "price": "500.00"
        },
        {
            "id": "2",
            "name": "清心丹",
            "price": "100.50"
        },
        {
            "id": "3",
            "name": "还魂丹",
            "price": "10000.04"
        },
        {
            "id": "5",
            "name": "天仙水",
            "price": "200.50"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例12

```json
{
    "list": [
        {
            "id": "5",
            "name": "天仙水",
            "price": "200.50"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例13

```json
{
    "list": [
        {
            "name": "包子",
            "price": "200.50"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例14

```json
{
    "list": [
        {
            "id": "8",
            "name": "包子",
            "price": "200.50"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例15

```json
{
    "list": [
        {
            "name": "包",
            "price": "200.50"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例16

```json
{
    "list": [
        {
            "id": "1",
            "name": "口腔科",
            "counts": "20"
        },
        {
            "id": "2",
            "name": "神经科",
            "counts": "20"
        },
        {
            "id": "3",
            "name": "内科",
            "counts": "20"
        },
        {
            "id": "4",
            "name": "妇科",
            "counts": "20"
        },
        {
            "id": "5",
            "name": "男科",
            "counts": "20"
        },
        {
            "id": "6",
            "name": "眼科",
            "counts": "20"
        },
        {
            "id": "7",
            "name": "皮肤科",
            "counts": "20"
        },
        {
            "id": "8",
            "name": "物科",
            "counts": "20"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例17

```json
{
    "list": [
        {
            "id": "7",
            "name": "皮肤科",
            "counts": "20"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例18

```json
{
    "list": [
        {
            "name": "内分泌科",
            "counts": "100"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例19

```json

    "list": [
        {
            "id": "9",
            "name": "内分泌科",
            "counts": "100"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例20

```json
{
    "list": [
        {
            "name": "内分泌科",
            "counts": "80"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例21

```json
{
    "list": [
        {
            "id": "1",
            "location": "一楼-202",
            "departmentId": "1"
        },
        {
            "id": "2",
            "location": "一楼-102",
            "departmentId": "1"
        },
        {
            "id": "3",
            "location": "一楼-103",
            "departmentId": "1"
        },
        {
            "id": "4",
            "location": "一楼-104",
            "departmentId": "2"
        },
        {
            "id": "5",
            "location": "一楼-105",
            "departmentId": "2"
        },
        {
            "id": "6",
            "location": "一楼-106",
            "departmentId": "4"
        },
        {
            "id": "7",
            "location": "一楼-107",
            "departmentId": "3"
        },
        {
            "id": "8",
            "location": "二楼-201",
            "departmentId": "3"
        },
        {
            "id": "9",
            "location": "二楼-202",
            "departmentId": "3"
        },
        {
            "id": "10",
            "location": "二楼-203",
            "departmentId": "3"
        },
        {
            "id": "11",
            "location": "二楼-204",
            "departmentId": "3"
        },
        {
            "id": "13",
            "location": "二楼-206",
            "departmentId": "4"
        },
        {
            "id": "17",
            "location": "222",
            "departmentId": "1"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例22

```json
{
    "list": [
        {
            "id": "1",
            "location": "一楼-202",
            "departmentId": "1"
        },
        {
            "id": "2",
            "location": "一楼-102",
            "departmentId": "1"
        },
        {
            "id": "3",
            "location": "一楼-103",
            "departmentId": "1"
        },
        {
            "id": "4",
            "location": "一楼-104",
            "departmentId": "2"
        },
        {
            "id": "5",
            "location": "一楼-105",
            "departmentId": "2"
        },
        {
            "id": "6",
            "location": "一楼-106",
            "departmentId": "4"
        },
        {
            "id": "7",
            "location": "一楼-107",
            "departmentId": "3"
        },
        {
            "id": "8",
            "location": "二楼-201",
            "departmentId": "3"
        },
        {
            "id": "9",
            "location": "二楼-202",
            "departmentId": "3"
        },
        {
            "id": "10",
            "location": "二楼-203",
            "departmentId": "3"
        },
        {
            "id": "11",
            "location": "二楼-204",
            "departmentId": "3"
        },
        {
            "id": "13",
            "location": "二楼-206",
            "departmentId": "4"
        },
        {
            "id": "17",
            "location": "222",
            "departmentId": "1"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例23

```json
{
    "list": [
        {
            "location": "地球",
            "departmentId": "2"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例24

```json
{
    "list": [
        {
            "id": "18",
            "location": "月球",
            "departmentId": "2"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例25

```json
{
    "list": [
        {
            "id": "18",
            "location": "月球",
            "departmentId": "2"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

* 挂号

| URL | 方法 | 参数 | 说明 | 实例 | 
| :--------: | :--------: | :----: | :----: | :----:  |
| /appointments | GET | 无 | 查看所有挂号 | 26 |
| /appointment | GET | doctorId | 查看医生的所有挂号 | 27 |
| /appointment/add | POST | name, idCard, sex, age, tel, consultingDate, doctorId, departmentId, consultingRoomId | 添加挂号 | 28 |
| /appointment/doctors | GET | 无 | 查看所有医生 | 29 |
| /appointment/doctor | GET | departmentId, consultingRoomId | 查看部门下的一个就诊室内的所有医生 | 30 |

> 实例26

```json
{
    "list": [
        {
            "id": "1",
            "consultingDate": "2018-12-12 12:00:00.0",
            "patient": {
                "id": "1",
                "name": "小红",
                "sex": "女",
                "age": "22"
            },
            "doctorName": "瑟莉娜",
            "department": "口腔科",
            "location": "一楼-202"
        },
        {
            "id": "5",
            "consultingDate": "2018-12-12 12:00:00.0",
            "patient": {
                "id": "2",
                "name": "嘻嘻",
                "sex": "女",
                "age": "19"
            },
            "doctorName": "瑟莉娜",
            "department": "口腔科",
            "location": "一楼-202"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例27

```json
{
    "list": [
        {
            "id": "1",
            "consultingDate": "2018-12-12 12:00:00.0",
            "patient": {
                "id": "1",
                "name": "小红",
                "sex": "女",
                "age": "22"
            },
            "doctorName": "瑟莉娜",
            "department": "口腔科",
            "location": "一楼-202"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例28

```json
{
    "list": [
        {
            "consultingDate": "2017-12-01 12:30",
            "doctorId": "1",
            "departmentId": "1",
            "consultingRoomId": "1",
            "patient": {
                "id": "3",
                "name": "test",
                "idCard": "44511120000955",
                "sex": "女",
                "age": "19",
                "tel": "15625172044"
            }
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例29

```json
{
    "list": [
        {
            "id": "1",
            "name": "瑟莉娜"
        },
        {
            "id": "2",
            "name": "test"
        },
        {
            "id": "8",
            "name": "临时"
        },
        {
            "id": "9",
            "name": "傻逼"
        },
        {
            "id": "11",
            "name": "拉拉"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例30

```json
{
    "list": [
        {
            "id": "1",
            "name": "瑟莉娜"
        },
        {
            "id": "2",
            "name": "test"
        },
        {
            "id": "8",
            "name": "临时"
        },
        {
            "id": "9",
            "name": "傻逼"
        },
        {
            "id": "11",
            "name": "拉拉"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

* 开病例模块

| URL | 方法 | 参数 | 说明 | 实例 |
| :--------: | :--------: | :----: | :----: | :----:  |
| /casereport/add | | POST | appointmentId, patientId, description, medicineId, counts (medicineId和counts都是一个拼接的字段. 拼接格式: medicineId: id1&id2, counts: 1&2) | 添加病例 | 31 |
| /casereport/update | POST | id, isPay(0表示未付款, 1表示已付款) | 修改病例, 只修改是否付款的字段 | 32 |

> 实例31

```json
{
    "list": [
        {
            "appointmentId": "1",
            "caseReportId": "10",
            "patientId": "1",
            "description": "发烧了",
            "isPay": false,
            "medicineLists": [
                {
                    "id": "1",
                    "counts": "2"
                },
                {
                    "id": "2",
                    "counts": "3"
                },
                {
                    "id": "3",
                    "counts": "4"
                }
            ]
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例32

```json
{
    "list": [],
    "code": 200,
    "reason": "success",
    "success": true
}
```

* 查看药品清单

| URL | 方法 | 参数 | 说明 | 实例 |
| :--------: | :--------: | :----: | :----: | :----:  |
|/medicine/pick | GET | reportId | 查看病例对应的药品清单 | 33 |

> 实例33

```json
{
    "list": {
        "reportId": "10",
        "medicineLists": [
            {
                "id": "1",
                "name": "脑白金",
                "counts": "2",
                "price": "500.00"
            },
            {
                "id": "2",
                "name": "清心丹",
                "counts": "3",
                "price": "100.50"
            },
            {
                "id": "3",
                "name": "还魂丹",
                "counts": "4",
                "price": "10000.04"
            }
        ]
    },
    "code": 200,
    "reason": "success",
    "success": true
}
```

* 付款模块

| URL | 方法 | 参数 | 说明 | 实例 |
| :--------: | :--------: | :----: | :----: | :----:  |
| /medicine/unpay | GET | 无 | 查看未付款的药单 | 34 |
| /medicine/pay | POST | reportId | 付款 | 35 |

> 实例34

```json
{
    "list": [
        {
            "totalPrice": "41300.66",
            "medicine": {
                "reportId": "6",
                "patientId": "1",
                "patientName": "小红",
                "medicineLists": [
                    {
                        "id": "1",
                        "name": "脑白金",
                        "counts": "2",
                        "price": "500.00"
                    },
                    {
                        "id": "2",
                        "name": "清心丹",
                        "counts": "3",
                        "price": "100.50"
                    },
                    {
                        "id": "3",
                        "name": "还魂丹",
                        "counts": "4",
                        "price": "10000.04"
                    }
                ]
            }
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

> 实例35

```json
{
    "list": {
        "reportId": "10",
        "medicineLists": [
            {
                "id": "1",
                "name": "脑白金",
                "counts": "2",
                "price": "500.00"
            },
            {
                "id": "2",
                "name": "清心丹",
                "counts": "3",
                "price": "100.50"
            },
            {
                "id": "3",
                "name": "还魂丹",
                "counts": "4",
                "price": "10000.04"
            }
        ]
    },
    "totalPrice": "41300.66",
    "code": 200,
    "reason": "success",
    "success": true
}
```

* 登录模块

| URL | 方法 | 参数 | 说明 | 实例 |
| :--------: | :--------: | :----: | :----: | :----:  |
| /login | POST | account, password | 登录 | 36 |

> 实例36

```json
{
    "list": [
        {
            "id": "2",
            "name": "test",
            "sex": "男",
            "age": 19,
            "tel": "15565872800",
            "title": "医生",
            "departmentName": "口腔科",
            "consultingRoomName": "一楼-202"
        }
    ],
    "code": 200,
    "reason": "success",
    "success": true
}
```

* 注销模块

| URL | 方法 | 参数 | 说明 | 实例 |
| :--------: | :--------: | :----: | :----: | :----:  |
| /logout | GET | 无 | 注销 | 37 |

> 实例37

```json
{
    "code": 200,
    "reason": "注销成功",
    "success": true
}
```
