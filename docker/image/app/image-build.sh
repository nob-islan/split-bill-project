#!/bin/bash

WORK_DIR='../../../split-bill-app'
JAR_NAME='split-bill-app-0.0.1-SNAPSHOT.jar'

# jar作成
${WORK_DIR}/mvnw -f ${WORK_DIR}/pom.xml package

# jarを一時ディレクトリにコピー
mkdir -p tmp
cp ${WORK_DIR}/target/${JAR_NAME} ./tmp

# コンテナイメージ作成
docker build . -t split-bill-app 

# 一時ディレクトリ削除
rm -r tmp
