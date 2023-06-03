#!/bin/bash

# mvn clean # 清空target目录
# mvn compile # 编译生成target下的class文件
mvn clean compile -Dmaven.test.skip=true
# mvn package  # 命令行清除编译打包
# mvn install # 打包生成Maven配置的jar包 Building jar: /workspaces/LeetCodeWars/javaOJ/target/localOJ-1.0-SNAPSHOT.jar
echo "==========================================="
java  '-cp' '/workspaces/LeetCodeWars/javaOJ/target/classes' 'com.tridu33.mineOJ.Temp' # 运行选定类

