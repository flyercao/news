/*
Navicat SQLite Data Transfer

Source Server         : topnews
Source Server Version : 30714
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 30714
File Encoding         : 65001

Date: 2014-06-13 20:07:24
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for android_metadata
-- ----------------------------
DROP TABLE IF EXISTS "main"."android_metadata";
CREATE TABLE android_metadata (locale TEXT);

-- ----------------------------
-- Records of android_metadata
-- ----------------------------
INSERT INTO "main"."android_metadata" VALUES ('zh_CN');

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS "main"."channel";
CREATE TABLE channel(_id INTEGER PRIMARY KEY AUTOINCREMENT, id INTEGER , name TEXT , orderId INTEGER , selected SELECTED);

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO "main"."channel" VALUES (1, 1, '推荐', 0, 1);
INSERT INTO "main"."channel" VALUES (2, 2, '热点', 1, 1);
INSERT INTO "main"."channel" VALUES (3, 3, '杭州', 2, 1);
INSERT INTO "main"."channel" VALUES (4, 4, '时尚', 3, 1);
INSERT INTO "main"."channel" VALUES (5, 5, '科技', 4, 1);
INSERT INTO "main"."channel" VALUES (6, 6, '体育', 5, 1);
INSERT INTO "main"."channel" VALUES (7, 7, '军事', 6, 1);
INSERT INTO "main"."channel" VALUES (8, 19, '娱乐', 7, 1);
INSERT INTO "main"."channel" VALUES (9, 8, '财经', 0, 0);
INSERT INTO "main"."channel" VALUES (10, 9, '汽车', 1, 0);
INSERT INTO "main"."channel" VALUES (11, 10, '房产', 2, 0);
INSERT INTO "main"."channel" VALUES (12, 11, '社会', 3, 0);
INSERT INTO "main"."channel" VALUES (13, 12, '情感', 4, 0);
INSERT INTO "main"."channel" VALUES (14, 13, '女人', 5, 0);
INSERT INTO "main"."channel" VALUES (15, 14, '旅游', 6, 0);
INSERT INTO "main"."channel" VALUES (16, 15, '健康', 7, 0);
INSERT INTO "main"."channel" VALUES (17, 16, '美女', 8, 0);
INSERT INTO "main"."channel" VALUES (18, 17, '游戏', 9, 0);
INSERT INTO "main"."channel" VALUES (19, 18, '数码', 10, 0);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS "main"."news";
CREATE TABLE news ( "id"    INTEGER PRIMARY KEY AUTOINCREMENT,"summary","newsAbstract","publishTime","picListString","collectStatus","source_url","picThr","isLarge","newsCategoryId","mark","picOne","likeStatus","commentNum","readStatus","title","newsId","source","newsCategory","interestedStatus","local","comment","picTwo" );

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO "main"."news" VALUES (1, '的积分', '积分', 3254365348, '', 0, 'http://www.sina.com.cn/', '', 1, 1, 0, 'http://upload.ct.youth.cn/2014/0613/1402629765353.jpg', 0, 22, 0, '世界杯10大富豪排行榜出炉 足坛名将家底大揭秘', 12661, 'http://edu.youth.cn/2014/0613/214787_33.shtml', '推荐', 0, 0, 0, null);

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "main"."sqlite_sequence";
CREATE TABLE sqlite_sequence(name,seq);

-- ----------------------------
-- Records of sqlite_sequence
-- ----------------------------
INSERT INTO "main"."sqlite_sequence" VALUES ('channel', 19);
INSERT INTO "main"."sqlite_sequence" VALUES ('news', 111);
