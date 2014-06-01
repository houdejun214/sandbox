package sandbox.app

import net.codingwell.scalaguice.{ScalaMultibinder, ScalaModule}
import sandbox.frame.spray.ApiPlugin
import sandbox.app.echo.EchoApi
import sandbox.app.climate.ClimateApi

class ApisModule extends ScalaModule {
  def configure {
    val multi = ScalaMultibinder.newSetBinder[ApiPlugin](binder)
    multi.addBinding.to[EchoApi]
    multi.addBinding.to[ClimateApi]
  }
}