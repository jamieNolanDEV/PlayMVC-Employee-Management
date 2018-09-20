
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/wdd/webapps/JamieJosh/conf/routes
// @DATE:Tue Mar 20 13:49:02 GMT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
