package sandbox.app.climate

import javax.inject.Inject
import sandbox.app.climate.model.{ClimateStats, ClimateQueryResult}
import sandbox.app.climate.wbclimate.WbClimateClient
import scala.concurrent._

/**
 */
trait ClimateService
{
  def query(location: String, fromYear: Int, toYear: Int): Future[ClimateQueryResult]
}

class ClimateServiceImpl @Inject()(wbClient: WbClimateClient)
                                  (implicit ec: ExecutionContext)
  extends ClimateService
{
  def query(location: String, fromYear: Int, toYear: Int)
  = {
    (for {
      temp <- wbClient.fetchTemperatureStats(location, fromYear, toYear)
      rain <- wbClient.fetchPrecipitationStats(location, fromYear, toYear)
    } yield {
      ClimateStats.fromData(location, fromYear, toYear, temp, rain)
    }) map { stats =>
      ClimateQueryResult(List(stats))
    }
  }


  def query2(location: String, fromYear: Int, toYear: Int) : Future[ClimateStats]
  = {
    val r1 = (for {
      temp <- wbClient.fetchTemperatureStats(location, fromYear, toYear)
      rain <- wbClient.fetchPrecipitationStats(location, fromYear, toYear)
    } yield {
      ClimateStats.fromData(location, fromYear, toYear, temp, rain)
    })
    r1


  }

}
