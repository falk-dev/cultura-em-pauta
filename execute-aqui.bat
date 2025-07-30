@echo off
chcp 65001 > nul
cd /d C:\Users\Falk\Documents\dev\git\cultura-em-pauta

:: Cria a pasta bin se não existir
if not exist bin mkdir bin

:: Compila todos os .java dentro de src
javac -d bin -sourcepath src src\application\Main.java

:: Executa o programa
java -cp bin application.Main

pause
