package com.github.nikdon.telepooz.model.methods

import com.github.nikdon.telepooz.IsResourceId
import com.github.nikdon.telepooz.model.ReplyMarkup
import com.github.nikdon.telepooz.tags.{ChatId, MessageId}
import shapeless.tag._


/**
  * Use this method to send point on the map. On success, the sent Message is returned.
  *
  * @param chat_id              Unique identifier for the target chat or username of the target channel
  *                             (in the format @channelusername)
  * @param latitude             Latitude of location
  * @param longitude            Longitude of location
  * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users
  *                             will receive a notification with no sound.
  * @param reply_to_message_id  If the message is a reply, ID of the original message
  * @param reply_markup         Additional interface options. A JSON-serialized object for an inline keyboard, custom
  *                             reply keyboard, instructions to hide reply keyboard or to force a reply from the user.
  */
case class SendLocation[A: IsResourceId](chat_id: A @@ ChatId,
                                         latitude: Double,
                                         longitude: Double,
                                         disable_notification: Option[Boolean] = None,
                                         reply_to_message_id: Option[Long @@ MessageId] = None,
                                         reply_markup: Option[ReplyMarkup] = None)