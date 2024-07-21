#!/bin/bash

WORK_DIR='../../../split-bill-web/'

# ビルド
npm run build --prefix ${WORK_DIR}

# 成果物を一時ディレクトリにコピー
mkdir -p tmp
cp -r ${WORK_DIR}/build ./tmp/build

# コンテナイメージ作成
docker build . -t split-bill-web

# 一時ディレクトリ削除
rm -r tmp
