@ECHO OFF

SET directory=%~dp0
SET jarname=mp3-tag-editor-0.0.3.jar
SET jarpath=%directory%%jarname%
java -jar "%jarpath%"

PAUSE
