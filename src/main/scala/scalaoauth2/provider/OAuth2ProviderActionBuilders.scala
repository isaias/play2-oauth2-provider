package scalaoauth2.provider

import play.api.mvc._

import scala.concurrent.ExecutionContext

trait OAuth2ProviderActionBuilders {

  implicit val executionContext: ExecutionContext

  def AuthorizedAction[U](handler: ProtectedResourceHandler[U]): ActionBuilder[({ type L[A] = AuthInfoRequest[A, U] })#L, AnyContent] = {
    AuthorizedActionFunction(handler) compose Action
  }

}

object OAuth2ProviderActionBuilders extends OAuth2ProviderActionBuilders {
  implicit val executionContext: ExecutionContext = play.api.libs.concurrent.Execution.defaultContext
}
