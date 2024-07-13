-- データベース作成
CREATE DATABASE spbdb;
USE spbdb;

-- テーブル作成: member_role
CREATE TABLE IF NOT EXISTS member_role (
    role_name VARCHAR(8) NOT NULL
    , weighting_value INT(1) NOT NULL
    , PRIMARY KEY(role_name)
);

-- 初期データ投入
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "部長"
    , 5
);
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "課長"
    , 3
);
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "課長代行"
    , 2
);
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "無し"
    , 1
);
