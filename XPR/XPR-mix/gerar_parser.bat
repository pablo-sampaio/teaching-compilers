set CUP_DIR="%cd%"\lib
cd src\xpr\version0
java -jar %CUP_DIR%\java-cup-11a.jar -parser ParserCUP <Parser.cup
@pause