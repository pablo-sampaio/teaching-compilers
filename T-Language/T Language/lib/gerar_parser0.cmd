java -jar java-cup-11a.jar -expect 0 -parser Parser <..\src\tlanguage\version0\Parser.cup
move /Y *.java ..\src\tlanguage\version0\
@pause