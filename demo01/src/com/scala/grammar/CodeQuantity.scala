package com.scala.grammar

/**
  * 减少代码量（高阶函数）
  */
class CodeQuantity {

    // 检查文件是否包含指定的字符串
    def filesContaining(query: String) =
        for (file <- filesHere; if file.getName.contains(query))
            yield file

    // 正则表达式匹配到字符串
    def filesRegex(query: String) =
        for (file <- filesHere; if file.getName.matches(query))
            yield file

    def filesEnding(query:String) =
        filesMatching(query,_.endsWith(_))

    // 传入自定义的匹配规则
    def filesMatching( query:String,
                       matcher: (String, String) => Boolean) = {
        for(file <- filesHere; if matcher(file.getName,query))
            yield file
    }

    private def filesHere = (new java.io.File(".")).listFiles

    def filesContaining02(query:String)=
        filesMatching(query,_.contains(_))

    // 检查文件是否以指定的字符串结尾
    object FileMatcher {
        def filesEnding(query: String) =
            for (file <- filesHere; if file.getName.endsWith(query))
                yield file
    }

    def filesRegex02(query:String) =
        filesMatching(query,_.matches(_))

    def filesMatching(matcher: (String) => Boolean) = {
        for(file <- filesHere; if matcher(file.getName))
            yield file
    }

    def filesEnding02(query:String) =
        filesMatching(_.endsWith(query))

    def filesContaining03(query:String)=
        filesMatching(_.contains(query))

    def filesRegex03(query:String) =
        filesMatching(_.matches(query))

}
