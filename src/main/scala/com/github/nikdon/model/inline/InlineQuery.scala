package com.github.nikdon.model.inline

import com.github.nikdon.ToDTO
import com.github.nikdon.ToDTO.syntax._
import com.github.nikdon.dto
import com.github.nikdon.model.{Location, User}
import com.github.nikdon.tags.QueryId
import shapeless.tag.@@


/**
  * This object represents an incoming inline query. When the user sends an empty query,
  * your bot could return some default or trending results.
  *
  * @param id       Unique identifier for this query
  * @param from     Sender
  * @param location Sender location, only for bots that request user location
  * @param query    Text of the query (up to 512 characters)
  * @param offset   Offset of the results to be returned, can be controlled by the bot
  */
case class InlineQuery(id: String @@ QueryId,
                       from: User,
                       location: Option[Location],
                       query: String,
                       offset: String)

object InlineQuery {
  implicit val toDTO: ToDTO[InlineQuery, dto.inline.InlineQuery] =
    ToDTO(i ⇒ dto.inline.InlineQuery(i.id, i.from.toDTO, i.location.map(_.toDTO), i.query, i.offset))
}