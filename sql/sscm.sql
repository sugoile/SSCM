/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : sscm

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 14/12/2020 22:02:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_course
-- ----------------------------
DROP TABLE IF EXISTS `c_course`;
CREATE TABLE `c_course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `credit` int(11) NULL DEFAULT NULL COMMENT '学分',
  `class_hours` int(11) NULL DEFAULT NULL COMMENT '学时',
  `plan_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计划类型',
  `teaching_class` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学班',
  `tid` bigint(20) NULL DEFAULT NULL COMMENT '教师id',
  `limited_election` int(11) NULL DEFAULT NULL COMMENT '限选人数',
  `class_number` int(11) NULL DEFAULT NULL COMMENT '开班人数',
  `choose_number` int(11) NULL DEFAULT NULL COMMENT '已选人数',
  `states` int(1) NULL DEFAULT NULL COMMENT '是否发布',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_course
-- ----------------------------
INSERT INTO `c_course` VALUES (1, '程序设计', 2, 2, '通识课', '二教207', 4, 60, 45, 1, 1);
INSERT INTO `c_course` VALUES (5, '计算机网络', 2, 2, '通识课', '2教407', 5, 60, 45, 1, 1);
INSERT INTO `c_course` VALUES (6, '算法设计', 2, 2, '通识课', '二教505', 4, 60, 45, 0, 1);
INSERT INTO `c_course` VALUES (8, 'javaweb应用', 2, 2, '选修课', '二教506', 5, 60, 45, 0, 1);

-- ----------------------------
-- Table structure for c_course_score
-- ----------------------------
DROP TABLE IF EXISTS `c_course_score`;
CREATE TABLE `c_course_score`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NULL DEFAULT NULL COMMENT '课程id',
  `sid` bigint(20) NULL DEFAULT NULL COMMENT '学生id',
  `tid` bigint(20) NULL DEFAULT NULL COMMENT '老师id',
  `score` int(10) NULL DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_course_score
-- ----------------------------
INSERT INTO `c_course_score` VALUES (1, 1, 6, 4, 100);
INSERT INTO `c_course_score` VALUES (2, 6, 6, 4, 100);

-- ----------------------------
-- Table structure for c_selection
-- ----------------------------
DROP TABLE IF EXISTS `c_selection`;
CREATE TABLE `c_selection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sno` bigint(20) NULL DEFAULT NULL COMMENT '学号',
  `tno` bigint(20) NULL DEFAULT NULL COMMENT '教工号',
  `cno` bigint(20) NULL DEFAULT NULL COMMENT '课程号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for d_deparment_staff
-- ----------------------------
DROP TABLE IF EXISTS `d_deparment_staff`;
CREATE TABLE `d_deparment_staff`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_id` bigint(20) NULL DEFAULT NULL,
  `staff_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of d_deparment_staff
-- ----------------------------
INSERT INTO `d_deparment_staff` VALUES (1, 1, 1);
INSERT INTO `d_deparment_staff` VALUES (2, 1, 2);
INSERT INTO `d_deparment_staff` VALUES (3, 2, 1);
INSERT INTO `d_deparment_staff` VALUES (4, 2, 2);
INSERT INTO `d_deparment_staff` VALUES (5, 3, 1);
INSERT INTO `d_deparment_staff` VALUES (6, 3, 2);
INSERT INTO `d_deparment_staff` VALUES (7, 4, 1);
INSERT INTO `d_deparment_staff` VALUES (8, 4, 2);
INSERT INTO `d_deparment_staff` VALUES (9, 5, 1);
INSERT INTO `d_deparment_staff` VALUES (10, 5, 2);
INSERT INTO `d_deparment_staff` VALUES (11, 6, 1);
INSERT INTO `d_deparment_staff` VALUES (12, 6, 2);
INSERT INTO `d_deparment_staff` VALUES (13, 7, 1);
INSERT INTO `d_deparment_staff` VALUES (14, 7, 2);
INSERT INTO `d_deparment_staff` VALUES (15, 8, 1);
INSERT INTO `d_deparment_staff` VALUES (16, 8, 2);
INSERT INTO `d_deparment_staff` VALUES (17, 9, 1);
INSERT INTO `d_deparment_staff` VALUES (18, 9, 2);
INSERT INTO `d_deparment_staff` VALUES (19, 10, 1);
INSERT INTO `d_deparment_staff` VALUES (20, 10, 2);

-- ----------------------------
-- Table structure for d_department
-- ----------------------------
DROP TABLE IF EXISTS `d_department`;
CREATE TABLE `d_department`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `affiliiated_institution` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of d_department
-- ----------------------------
INSERT INTO `d_department` VALUES (1, '经济与管理学院', 2);
INSERT INTO `d_department` VALUES (2, '计算机科学与软件学院、大数据学院', 2);
INSERT INTO `d_department` VALUES (3, '政法学院、知识产权学院', 2);
INSERT INTO `d_department` VALUES (4, '环境与化学工程学院', 2);
INSERT INTO `d_department` VALUES (5, '教育科学学院', 2);
INSERT INTO `d_department` VALUES (6, '食品与制药工程学院', 2);
INSERT INTO `d_department` VALUES (7, '体育与健康学院', 2);
INSERT INTO `d_department` VALUES (8, '旅游与历史文化学院', 2);
INSERT INTO `d_department` VALUES (9, '文学院', 2);
INSERT INTO `d_department` VALUES (10, '音乐学院', 2);
INSERT INTO `d_department` VALUES (11, '外国语学院', 2);
INSERT INTO `d_department` VALUES (12, '美术学院', 2);
INSERT INTO `d_department` VALUES (13, '数学与统计学院', 2);
INSERT INTO `d_department` VALUES (14, '马克思主义学院', 2);
INSERT INTO `d_department` VALUES (15, '生命科学学院', 2);
INSERT INTO `d_department` VALUES (16, '教师教育学院', 2);
INSERT INTO `d_department` VALUES (17, '机械与汽车工程学院', 2);
INSERT INTO `d_department` VALUES (18, '中德设计学院、工业设计学院', 2);
INSERT INTO `d_department` VALUES (19, '电子与电气工程学院', 2);
INSERT INTO `d_department` VALUES (20, '创新创业学院', 2);

-- ----------------------------
-- Table structure for d_institution
-- ----------------------------
DROP TABLE IF EXISTS `d_institution`;
CREATE TABLE `d_institution`  (
  `id` bigint(21) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of d_institution
-- ----------------------------
INSERT INTO `d_institution` VALUES (1, '党政管理机构');
INSERT INTO `d_institution` VALUES (2, '教学机构');
INSERT INTO `d_institution` VALUES (3, '教辅机构');
INSERT INTO `d_institution` VALUES (4, '科研机构');
INSERT INTO `d_institution` VALUES (5, '群团组织');
INSERT INTO `d_institution` VALUES (6, '附属机构');

-- ----------------------------
-- Table structure for d_position
-- ----------------------------
DROP TABLE IF EXISTS `d_position`;
CREATE TABLE `d_position`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of d_position
-- ----------------------------
INSERT INTO `d_position` VALUES (1, '院长');
INSERT INTO `d_position` VALUES (2, '副院长');

-- ----------------------------
-- Table structure for d_staff
-- ----------------------------
DROP TABLE IF EXISTS `d_staff`;
CREATE TABLE `d_staff`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `affiliiated_position` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of d_staff
-- ----------------------------
INSERT INTO `d_staff` VALUES (1, '张三', 1);
INSERT INTO `d_staff` VALUES (2, '李四', 2);

-- ----------------------------
-- Table structure for u_admin
-- ----------------------------
DROP TABLE IF EXISTS `u_admin`;
CREATE TABLE `u_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_admin
-- ----------------------------
INSERT INTO `u_admin` VALUES (1, 'admin', '$2a$10$adY0LQcjihzJlODbSvw8lu59V1iTCWOlMnZm/6CDVzN4GjczNlpzK', NULL, '160487079@qq.com', 'xsg', '系统管理员', '2020-09-06 19:38:54', '2020-12-14 11:56:02', 1);
INSERT INTO `u_admin` VALUES (11, 'test', '$2a$10$9jSGqkjD5uBCUOeyHtNXnecF.0lWzzrHiXOY9ZI8OucE8H2nqykja', NULL, '160487079@qq.com', 'test', 'test', '2020-11-12 10:45:35', '2020-12-11 14:35:48', 1);

-- ----------------------------
-- Table structure for u_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `u_admin_role`;
CREATE TABLE `u_admin_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_admin_role
-- ----------------------------
INSERT INTO `u_admin_role` VALUES (82, 1, 1);
INSERT INTO `u_admin_role` VALUES (86, 1, 10);

-- ----------------------------
-- Table structure for u_api
-- ----------------------------
DROP TABLE IF EXISTS `u_api`;
CREATE TABLE `u_api`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父id',
  `api_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `api_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'api请求方式',
  `api_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_api
-- ----------------------------
INSERT INTO `u_api` VALUES (2, 6, 'test', 'GET', '/test/test1', '测试使用接口', 101);
INSERT INTO `u_api` VALUES (3, 6, '获取线型前端菜单(需要账号)', 'GET', '/admin/getMenuList', '获取线性前端菜单(需要账号)', 102);
INSERT INTO `u_api` VALUES (4, 6, '获取树型前端菜单(需要账号)', 'GET', '/admin/getMenuTree', '获取树型前端菜单(需要账号)', 103);
INSERT INTO `u_api` VALUES (5, 6, '注册用户', 'POST', '/admin/Register', '注册用户', 104);
INSERT INTO `u_api` VALUES (6, 8, '用户管理', NULL, '/admin', '用户管理', 100);
INSERT INTO `u_api` VALUES (7, 8, '菜单管理', NULL, '/menu', '菜单管理', 120);
INSERT INTO `u_api` VALUES (8, 0, '管理员管理', NULL, '', '管理员管理', 10);
INSERT INTO `u_api` VALUES (9, 6, '获取用户列表', 'GET', '/admin/getAdminList/*', '获取用户列表', 105);
INSERT INTO `u_api` VALUES (10, 6, '删除多个用户', 'GET', '/admin/delAdminList/*', '删除多个用户', 106);
INSERT INTO `u_api` VALUES (11, 6, '删除单个用户', 'GET', '/admin/delAdminOne/*', '删除单个用户', 107);
INSERT INTO `u_api` VALUES (12, 6, '修改用户信息', 'POST', '/admin/updateAdmin/*', '修改用户信息', 108);
INSERT INTO `u_api` VALUES (13, 6, '获取编辑用户信息', 'GET', '/admin/getEditAdmin/*', '获取编辑用户信息', 109);
INSERT INTO `u_api` VALUES (14, 6, '更改用户状态', 'GET', '/admin/updateStatu/*', '更改用户状态', 110);
INSERT INTO `u_api` VALUES (15, 8, '角色管理', NULL, '/role', '角色管理', 140);
INSERT INTO `u_api` VALUES (16, 15, '获取角色列表', 'GET', '/role/getRoleList', '获取角色列表', 141);
INSERT INTO `u_api` VALUES (17, 15, '添加角色', 'POST', '/role/addRole', '添加角色', 142);
INSERT INTO `u_api` VALUES (18, 15, '修改角色信息', 'POST', '/role/updateRole/*', '修改角色信息', 143);
INSERT INTO `u_api` VALUES (19, 15, '删除单个角色', 'GET', '/role/delRole/*', '删除单个角色', 144);
INSERT INTO `u_api` VALUES (20, 15, '删除多个角色', 'GET', '/role/delRoleList', '删除多个角色', 145);
INSERT INTO `u_api` VALUES (21, 15, '检查角色链接用户数', 'GET', '/role/checkRoleAdminRel/*', '检查角色链接用户数', 146);
INSERT INTO `u_api` VALUES (22, 15, '检查多个角色链接用户数', 'GET', '/role/checkRoleAdminRelList', '检查多个角色链接用户数', 147);
INSERT INTO `u_api` VALUES (23, 15, '角色获取分配用户', 'GET', '/role/getAssignAdminList', '角色获取分配用户线型', 148);
INSERT INTO `u_api` VALUES (24, 15, '角色获取所链接用户', 'GET', '/role/checkLinkAdmin/*', '角色获取所链接用户', 149);
INSERT INTO `u_api` VALUES (25, 15, '角色分配用户', 'POST', '/role/assignRoleToAdmin/*', '角色分配用户', 150);
INSERT INTO `u_api` VALUES (26, 6, '用户分配角色', 'POST', '/admin/assignAdminToRole/*', '用户分配角色', 111);
INSERT INTO `u_api` VALUES (27, 6, '用户获取分配角色', 'GET', '/admin/getAssignRoleList', '用户获取分配角色', 112);
INSERT INTO `u_api` VALUES (28, 6, '用户获取所链接角色', 'GET', '/admin/checkLinkRole/*', '用户获取所链接角色', 113);
INSERT INTO `u_api` VALUES (29, 7, '获取所有线型菜单', 'GET', '/menu/getMenuList', '获取所有线型菜单', 121);
INSERT INTO `u_api` VALUES (30, 7, '获取所有树型菜单', 'GET', '/menu/getMenuTree', '获取所有树型菜单', 122);
INSERT INTO `u_api` VALUES (31, 15, '角色获取所链接菜单', 'GET', '/role/checkLinkMenu/*', '角色获取所链接菜单', 151);
INSERT INTO `u_api` VALUES (32, 15, '角色分配菜单', 'POST', '/role/assignRoleToMenu/*', '角色分配菜单', 152);
INSERT INTO `u_api` VALUES (33, 8, '权限管理', NULL, '/api', '权限管理', 160);
INSERT INTO `u_api` VALUES (34, 33, '获取树型Api', 'GET', '/api/getApiTree', '获取树型Api', 161);
INSERT INTO `u_api` VALUES (35, 33, '获取线型Api', 'GET', '/api/getApiList', '获取线型Api', 162);
INSERT INTO `u_api` VALUES (36, 15, '角色获取所链接Api', 'GET', '/role/checkLinkApi/*', '角色获取所链接Api', 153);
INSERT INTO `u_api` VALUES (37, 15, '角色分配权限', 'POST', '/role/assignRoleToApi/*', '角色分配权限', 154);
INSERT INTO `u_api` VALUES (38, 33, 'Api获取所链接角色', 'GET', '/api/checkLinkRole/*', 'Api获取所链接角色', 163);
INSERT INTO `u_api` VALUES (39, 33, 'Api分配用户', 'POST', '/api/assignApiToRole/*', 'Api分配用户', 164);
INSERT INTO `u_api` VALUES (40, 33, '获取0级与1级Api', 'GET', '/api/getOneAndTwoApis', '获取0级与1级Api', 165);
INSERT INTO `u_api` VALUES (41, 33, '添加API', 'POST', '/api/addApi', '添加API', 166);
INSERT INTO `u_api` VALUES (48, 33, '修改API信息', 'POST', '/api/updateApi/*', '修改API信息', 167);
INSERT INTO `u_api` VALUES (54, 33, '修改一二级API信息', 'POST', '/api//updatePApi', '修改一二级API信息', 168);
INSERT INTO `u_api` VALUES (55, 33, '删除单个API', 'GET', '/api/delApi/*', '删除单个API', 169);
INSERT INTO `u_api` VALUES (57, 0, '部门管理', NULL, '', '部门管理', 20);
INSERT INTO `u_api` VALUES (58, 57, '部门和院系信息管理', NULL, '/department', '部门和院系信息管理', 200);
INSERT INTO `u_api` VALUES (59, 58, '获取所有部门和院系信息', 'GET', '/department/getDepartment', '获取所有部门和院系信息', 201);
INSERT INTO `u_api` VALUES (60, 58, '获取所有院系', 'GET', '/department/getDepartmentNoSelect', '获取所有院系', 202);
INSERT INTO `u_api` VALUES (61, 0, '学生管理', NULL, NULL, '学生管理', 30);
INSERT INTO `u_api` VALUES (62, 61, '学生基本操作', NULL, '/Student', '学生基本操作', 300);
INSERT INTO `u_api` VALUES (63, 62, '添加学生并加入使用者列表', 'POST', '/Student/AddStudent', '添加学生并加入使用者列表', 301);
INSERT INTO `u_api` VALUES (64, 62, '获取学生', 'GET', '/Student/getStudent', '获取学生', 302);
INSERT INTO `u_api` VALUES (65, 62, '修改学生信息', 'POST', '/Student/UpdateStudent/*', '修改学生信息', 303);
INSERT INTO `u_api` VALUES (66, 62, '删除某一学生', 'GET', '/Student/DeleteOne/*', '删除某一学生', 304);
INSERT INTO `u_api` VALUES (67, 62, '批量删除学生', 'GET', '/Student/Delete', '批量删除学生', 305);
INSERT INTO `u_api` VALUES (68, 0, '教师管理', NULL, NULL, '学生管理', 40);
INSERT INTO `u_api` VALUES (69, 68, '教师基本操作', NULL, '/Teacher', '教师基本操作', 400);
INSERT INTO `u_api` VALUES (70, 69, '添加教师并加入使用者列表', 'POST', '/Teacher/AddTeacher', '添加教师并加入使用者列表', 401);
INSERT INTO `u_api` VALUES (71, 69, '获取教师', 'GET', '/Teacher/getTeacher', '获取教师', 402);
INSERT INTO `u_api` VALUES (72, 69, '修改学生信息', 'POST', '/Teacher/UpdateTeacher/*', '修改学生信息', 403);
INSERT INTO `u_api` VALUES (73, 69, '删除某一教师', 'GET', '/Teacher/DeleteOne/*', '删除某一教师', 404);
INSERT INTO `u_api` VALUES (74, 69, '批量删除教师', 'GET', '/Teacher/Delete', '批量删除教师', 405);
INSERT INTO `u_api` VALUES (75, 80, '添加课程', 'POST', '/Course/AddCourse', '添加课程', 321);
INSERT INTO `u_api` VALUES (76, 80, '获取课程', 'GET', '/Course/getCourse', '获取课程', 322);
INSERT INTO `u_api` VALUES (77, 80, '修改课程', 'POST', '/Course/UpdateCourse/*', '修改课程', 333);
INSERT INTO `u_api` VALUES (78, 80, '删除某一课程', 'GET', '/Course/DeleteOne/*', '删除某一课程', 334);
INSERT INTO `u_api` VALUES (79, 80, '批量删除课程', 'GET', '/Course/Delete', '批量删除课程', 345);
INSERT INTO `u_api` VALUES (80, 61, '课程管理', NULL, '/Course', '课程管理', 320);
INSERT INTO `u_api` VALUES (81, 69, '获取教师不分页', 'GET', '/Teacher/getTeacherNoSelect', '获取教师不分页', 406);
INSERT INTO `u_api` VALUES (82, 80, '更改发布状态', 'GET', '/Course/UpdateStates/*', '更改发布状态', 346);

-- ----------------------------
-- Table structure for u_font_menu
-- ----------------------------
DROP TABLE IF EXISTS `u_font_menu`;
CREATE TABLE `u_font_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `font_menu_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` bigint(20) NULL DEFAULT NULL,
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `font_icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_font_menu
-- ----------------------------
INSERT INTO `u_font_menu` VALUES (1, '学生管理', 0, '/student', 100, 'xuesheng', '学生管理');
INSERT INTO `u_font_menu` VALUES (2, '教师管理', 0, '/teacher', 200, 'laoshi', '教师管理');
INSERT INTO `u_font_menu` VALUES (3, '部门管理', 0, '/department', 300, 'navicon-jsgl', '部门管理');
INSERT INTO `u_font_menu` VALUES (4, '管理员管理', 0, '/admin', 400, 'guanliyuan', '管理员管理');
INSERT INTO `u_font_menu` VALUES (5, '信息统计', 0, '/inform', 500, 'tongji', '信息统计');
INSERT INTO `u_font_menu` VALUES (6, '菜单管理', 4, '/admin/menu', 401, 'caidan1', '菜单管理');
INSERT INTO `u_font_menu` VALUES (7, '权限管理', 4, '/admin/api', 402, 'authority', '权限管理');
INSERT INTO `u_font_menu` VALUES (8, '角色管理', 4, '/admin/role', 403, 'jiaoseguanli', '角色管理');
INSERT INTO `u_font_menu` VALUES (9, '用户管理', 4, '/admin/user', 404, 'user', '用户管理');
INSERT INTO `u_font_menu` VALUES (10, '基本信息管理', 1, '/student/basic', 101, 'jibenxinxi', '基本信息管理');
INSERT INTO `u_font_menu` VALUES (11, '奖学金信息管理', 1, '/student/scholarship', 102, 'jiangxuejinzhongleiguanli', '奖学金信息管理');
INSERT INTO `u_font_menu` VALUES (12, '处分信息管理', 1, '/student/punishment', 103, 'weijichufenguanli', '处分信息管理');
INSERT INTO `u_font_menu` VALUES (13, '选课信息管理', 1, '/student/courseSelection', 104, 'xuanke-xian', '选课信息管理');
INSERT INTO `u_font_menu` VALUES (14, '四六级报名信息管理', 1, '/student/cet', 105, 'kaoshi', '四六级报名信息管理');
INSERT INTO `u_font_menu` VALUES (15, '教师教学评估管理', 1, '/student/teacherAssessment', 106, 'cz-ldpg', '教师教学评估管理');
INSERT INTO `u_font_menu` VALUES (16, '课表信息管理', 1, '/student/timetable', 107, 'kebiaoxinxi', '课表信息管理');
INSERT INTO `u_font_menu` VALUES (17, '毕业生实习信息管理', 1, '/student/graduateInternship', 108, 'w_biyesheng', '毕业生实习信息管理');
INSERT INTO `u_font_menu` VALUES (18, '教师基本信息管理', 2, '/teacher/basic', 201, 'jibenxinxi', '教师基本信息管理');
INSERT INTO `u_font_menu` VALUES (19, '教师成绩上传管理', 2, '/teacher/scoreUpload', 202, 'chengjifenxi', '教师成绩上传管理');
INSERT INTO `u_font_menu` VALUES (20, '年终教学评估管理', 2, '/teacher/teachingAssessment', 203, 'cz-ldpg', '年终奖教学评估管理');
INSERT INTO `u_font_menu` VALUES (21, '教师用户信息管理', 2, '/teacher/information', 204, 'jiaoshizigezheng', '教师用户信息管理');
INSERT INTO `u_font_menu` VALUES (22, '教师课表信息管理', 2, '/teacher/timetable', 205, 'kebiaoxinxi', '教师课表信息管理');
INSERT INTO `u_font_menu` VALUES (23, '部门和院系管理', 3, '/department/departments', 301, 'xueyuan1', '部门和院系管理');
INSERT INTO `u_font_menu` VALUES (24, '部门和院系信息管理', 3, '/department/departmentsInformation', 301, 'yuanxiao', '部门和院系信息管理');
INSERT INTO `u_font_menu` VALUES (25, '各院系年级成绩排名统计', 5, '/inform/gradesRaking', 501, 'icon-test', '各院系年级成绩排名统计');
INSERT INTO `u_font_menu` VALUES (26, '各院系年终教师评估统计', 5, '/inform/teacherAssessment', 502, 'icon-test', '各院系年终教师评估统计');
INSERT INTO `u_font_menu` VALUES (27, '各院系取消学位信息统计', 5, '/inform/cancelDegree', 503, 'icon-test', '各院系取消学位信息统计');
INSERT INTO `u_font_menu` VALUES (28, '各院系等级考试成绩统计', 5, '/inform/gradeExamination', 504, 'icon-test', '各院系等级考试成绩统计');
INSERT INTO `u_font_menu` VALUES (29, '各院系受处分信息统计', 5, '/inform/punishment', 505, 'icon-test', '各院系受处分信息统计');
INSERT INTO `u_font_menu` VALUES (30, '各院系奖学金信息统计', 5, '/inform/scholarship', 506, 'icon-test', '各院系奖学金信息统计');

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES (1, '系统管理员', '系统管理员', 101);
INSERT INTO `u_role` VALUES (10, '测试角色', '测试角色', 102);
INSERT INTO `u_role` VALUES (11, '教师用户', '教师用户', 103);
INSERT INTO `u_role` VALUES (12, '学生用户', '学生用户', 104);

-- ----------------------------
-- Table structure for u_role_api
-- ----------------------------
DROP TABLE IF EXISTS `u_role_api`;
CREATE TABLE `u_role_api`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `api_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_role_api
-- ----------------------------
INSERT INTO `u_role_api` VALUES (3, 1, 3);
INSERT INTO `u_role_api` VALUES (4, 1, 4);
INSERT INTO `u_role_api` VALUES (5, 1, 5);
INSERT INTO `u_role_api` VALUES (6, 1, 9);
INSERT INTO `u_role_api` VALUES (7, 1, 10);
INSERT INTO `u_role_api` VALUES (8, 1, 11);
INSERT INTO `u_role_api` VALUES (9, 1, 12);
INSERT INTO `u_role_api` VALUES (10, 1, 13);
INSERT INTO `u_role_api` VALUES (11, 1, 14);
INSERT INTO `u_role_api` VALUES (12, 1, 16);
INSERT INTO `u_role_api` VALUES (13, 1, 17);
INSERT INTO `u_role_api` VALUES (14, 1, 18);
INSERT INTO `u_role_api` VALUES (15, 1, 19);
INSERT INTO `u_role_api` VALUES (16, 1, 20);
INSERT INTO `u_role_api` VALUES (17, 1, 21);
INSERT INTO `u_role_api` VALUES (18, 1, 22);
INSERT INTO `u_role_api` VALUES (19, 1, 23);
INSERT INTO `u_role_api` VALUES (20, 1, 24);
INSERT INTO `u_role_api` VALUES (21, 1, 25);
INSERT INTO `u_role_api` VALUES (22, 1, 26);
INSERT INTO `u_role_api` VALUES (23, 1, 27);
INSERT INTO `u_role_api` VALUES (24, 1, 28);
INSERT INTO `u_role_api` VALUES (25, 1, 29);
INSERT INTO `u_role_api` VALUES (26, 1, 30);
INSERT INTO `u_role_api` VALUES (27, 1, 31);
INSERT INTO `u_role_api` VALUES (28, 1, 32);
INSERT INTO `u_role_api` VALUES (29, 1, 34);
INSERT INTO `u_role_api` VALUES (30, 1, 35);
INSERT INTO `u_role_api` VALUES (31, 1, 36);
INSERT INTO `u_role_api` VALUES (32, 1, 37);
INSERT INTO `u_role_api` VALUES (47, 1, 38);
INSERT INTO `u_role_api` VALUES (48, 1, 39);
INSERT INTO `u_role_api` VALUES (52, 1, 40);
INSERT INTO `u_role_api` VALUES (53, 1, 41);
INSERT INTO `u_role_api` VALUES (54, 1, 48);
INSERT INTO `u_role_api` VALUES (55, 1, 54);
INSERT INTO `u_role_api` VALUES (56, 1, 2);
INSERT INTO `u_role_api` VALUES (57, 10, 2);
INSERT INTO `u_role_api` VALUES (58, 1, 55);
INSERT INTO `u_role_api` VALUES (59, 1, 59);
INSERT INTO `u_role_api` VALUES (60, 11, 3);
INSERT INTO `u_role_api` VALUES (61, 11, 4);
INSERT INTO `u_role_api` VALUES (68, 12, 3);
INSERT INTO `u_role_api` VALUES (69, 12, 4);
INSERT INTO `u_role_api` VALUES (70, 1, 60);
INSERT INTO `u_role_api` VALUES (71, 1, 63);
INSERT INTO `u_role_api` VALUES (72, 1, 64);
INSERT INTO `u_role_api` VALUES (73, 1, 63);
INSERT INTO `u_role_api` VALUES (74, 1, 64);
INSERT INTO `u_role_api` VALUES (75, 1, 65);
INSERT INTO `u_role_api` VALUES (76, 1, 66);
INSERT INTO `u_role_api` VALUES (77, 1, 67);
INSERT INTO `u_role_api` VALUES (78, 1, 70);
INSERT INTO `u_role_api` VALUES (79, 1, 71);
INSERT INTO `u_role_api` VALUES (80, 1, 72);
INSERT INTO `u_role_api` VALUES (81, 1, 73);
INSERT INTO `u_role_api` VALUES (82, 1, 74);
INSERT INTO `u_role_api` VALUES (83, 1, 75);
INSERT INTO `u_role_api` VALUES (84, 1, 76);
INSERT INTO `u_role_api` VALUES (85, 1, 77);
INSERT INTO `u_role_api` VALUES (86, 1, 78);
INSERT INTO `u_role_api` VALUES (87, 1, 79);
INSERT INTO `u_role_api` VALUES (88, 1, 81);
INSERT INTO `u_role_api` VALUES (89, 1, 82);

-- ----------------------------
-- Table structure for u_role_font_menu
-- ----------------------------
DROP TABLE IF EXISTS `u_role_font_menu`;
CREATE TABLE `u_role_font_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `font_menu_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_role_font_menu
-- ----------------------------
INSERT INTO `u_role_font_menu` VALUES (1, 1, 1);
INSERT INTO `u_role_font_menu` VALUES (2, 1, 2);
INSERT INTO `u_role_font_menu` VALUES (3, 1, 3);
INSERT INTO `u_role_font_menu` VALUES (4, 1, 4);
INSERT INTO `u_role_font_menu` VALUES (5, 1, 5);
INSERT INTO `u_role_font_menu` VALUES (6, 1, 6);
INSERT INTO `u_role_font_menu` VALUES (7, 1, 7);
INSERT INTO `u_role_font_menu` VALUES (8, 1, 8);
INSERT INTO `u_role_font_menu` VALUES (9, 1, 9);
INSERT INTO `u_role_font_menu` VALUES (10, 1, 10);
INSERT INTO `u_role_font_menu` VALUES (11, 1, 11);
INSERT INTO `u_role_font_menu` VALUES (12, 1, 12);
INSERT INTO `u_role_font_menu` VALUES (13, 1, 13);
INSERT INTO `u_role_font_menu` VALUES (14, 1, 14);
INSERT INTO `u_role_font_menu` VALUES (15, 1, 15);
INSERT INTO `u_role_font_menu` VALUES (16, 1, 16);
INSERT INTO `u_role_font_menu` VALUES (17, 1, 17);
INSERT INTO `u_role_font_menu` VALUES (18, 1, 18);
INSERT INTO `u_role_font_menu` VALUES (19, 1, 19);
INSERT INTO `u_role_font_menu` VALUES (20, 1, 20);
INSERT INTO `u_role_font_menu` VALUES (21, 1, 21);
INSERT INTO `u_role_font_menu` VALUES (22, 1, 22);
INSERT INTO `u_role_font_menu` VALUES (23, 1, 23);
INSERT INTO `u_role_font_menu` VALUES (24, 1, 24);
INSERT INTO `u_role_font_menu` VALUES (25, 1, 25);
INSERT INTO `u_role_font_menu` VALUES (26, 1, 26);
INSERT INTO `u_role_font_menu` VALUES (27, 1, 27);
INSERT INTO `u_role_font_menu` VALUES (28, 1, 28);
INSERT INTO `u_role_font_menu` VALUES (29, 1, 29);
INSERT INTO `u_role_font_menu` VALUES (30, 1, 30);

-- ----------------------------
-- Table structure for u_student
-- ----------------------------
DROP TABLE IF EXISTS `u_student`;
CREATE TABLE `u_student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sno` bigint(20) NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deptid` bigint(20) NULL DEFAULT NULL COMMENT '院系id',
  `classes` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班别',
  `grade` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  `campus` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在校区',
  `student_status` int(1) NULL DEFAULT NULL COMMENT '学生状态：1->在读',
  `study_status` int(1) NULL DEFAULT NULL COMMENT '学籍状态：1->有学籍',
  `admission_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入学时间',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_student
-- ----------------------------
INSERT INTO `u_student` VALUES (6, 201824113158, '许仕果', 2, '软件1班', '2018', '肇庆学院', 1, 1, '201809', '$2a$10$aeMv.w4TTKmBMRQfdKdfD.88mvpTnxFQk3AcsYghKsguLPOqiVpdG', '2020-12-13 20:24:09', '2020-12-14 16:06:10', 1);
INSERT INTO `u_student` VALUES (7, 201824113156, '房才顺', 2, '软件1班', '2018', '肇庆学院', 1, 1, '201809', '$2a$10$UBFX4gzvgMV5TwNwP.eAwOBxd6HgLHQxjKoVntuszFgGJCfFqFoTi', '2020-12-13 20:25:06', NULL, 1);
INSERT INTO `u_student` VALUES (8, 201824113101, '黎剑豪', 2, '软件1班', '2018', '肇庆学院', 1, 1, '201809', '$2a$10$NWMiKMtlhHSF6Xh7ITLILuYCt0Jx5YQ7kc7aSfYzuUkjcCQmXHinS', '2020-12-13 21:38:15', NULL, 1);
INSERT INTO `u_student` VALUES (9, 201824113128, '吴灿标', 2, '软件1班', '2018', '肇庆学院', 1, 1, '201809', '$2a$10$RjG2eR.2e/C8E1tA/Xn6ZuUNCcAhSpYjszbJrHHDVIWqZE1m7JCv6', '2020-12-13 21:38:59', NULL, 1);
INSERT INTO `u_student` VALUES (10, 201824113102, '杜胤思', 2, '软件1班', '2018', '肇庆学院', 1, 1, '201809', '$2a$10$ScOMcilsF.Nz.j2iCOh1RumIfNO/ALz.gu99vsUINXtPIYO0TuM92', '2020-12-13 21:39:36', NULL, 1);

-- ----------------------------
-- Table structure for u_student_course
-- ----------------------------
DROP TABLE IF EXISTS `u_student_course`;
CREATE TABLE `u_student_course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NULL DEFAULT NULL,
  `course_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_student_course
-- ----------------------------
INSERT INTO `u_student_course` VALUES (10, 6, 1);
INSERT INTO `u_student_course` VALUES (11, 6, 5);

-- ----------------------------
-- Table structure for u_teacher
-- ----------------------------
DROP TABLE IF EXISTS `u_teacher`;
CREATE TABLE `u_teacher`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tno` bigint(20) NULL DEFAULT NULL COMMENT '教工号',
  `tname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `education` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `position` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `Maincourse` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主讲课程',
  `Secondcourse` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副讲课程',
  `deptid` bigint(20) NULL DEFAULT NULL COMMENT '所在院系id',
  `campus` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在校区',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_teacher
-- ----------------------------
INSERT INTO `u_teacher` VALUES (4, 1001, '张三', 1, '博士', '教师', 'C语言', 'java', 2, '肇庆学院', '$2a$10$NjZs0J3GEeVi3seq40icveGdHDwExyGi5XV5HQ2sjWUdPjCUX1tMq', '2020-12-13 21:36:38', '2020-12-14 14:26:52', 1);
INSERT INTO `u_teacher` VALUES (5, 1002, '李四', 1, '硕士', '教师', '计算机网络', '大学物理', 2, '肇庆学院', '$2a$10$gE2aO3ouPZabvfwnjsBDzeAe/lZT6M/iwBLrn6cOx6tyPT08U98UK', '2020-12-13 21:37:19', '2020-12-14 21:01:25', 1);
INSERT INTO `u_teacher` VALUES (6, 1003, '王五', 1, '博士', '教师', '算法分析', '算法分析', 2, '肇庆学院', '$2a$10$z3oUJbrDXKEGEy8lF3mlKOtwXd33k/2Ya8I/5hcLrInHeEv5uGJTG', '2020-12-14 20:59:08', '2020-12-14 21:00:59', 1);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  `type` int(1) NULL DEFAULT NULL COMMENT '老师或者学生：0->老师；1->学生',
  `uid` bigint(20) NULL DEFAULT NULL COMMENT '老师或学生链接的ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES (1, '许仕果', '$2a$10$sSVLMZze8JTYQVoKVHLGmulakCfpKmP4NnON9ktkI70rUTiFa7ygu', '2020-12-13 16:27:30', NULL, 1, 1, 4);
INSERT INTO `u_user` VALUES (2, '房才顺', '$2a$10$qZ7IPalFcxBIvZmnFLkHF.hQ7amGQQ4v8wfhu3PCvV2vDXTD/7awu', '2020-12-13 16:31:19', NULL, 1, 1, 5);

SET FOREIGN_KEY_CHECKS = 1;
