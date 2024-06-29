-- データベース作成
CREATE DATABASE spbdb;
USE spbdb;

-- テーブル作成: member_role
CREATE TABLE IF NOT EXISTS member_role (
    id INT AUTO_INCREMENT
    , role_name VARCHAR(8) NOT NULL
    , weighting_value INT NOT NULL
    , PRIMARY KEY(id)
);

-- 初期データ投入
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "部長"
    , 50
);
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "課長"
    , 30
);
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "課長代行"
    , 20
);
INSERT INTO member_role (
    role_name
    , weighting_value
) VALUES (
    "無し"
    , 10
);
