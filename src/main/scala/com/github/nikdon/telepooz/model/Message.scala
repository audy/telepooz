package com.github.nikdon.telepooz.model

import java.util.Date

import com.github.nikdon.telepooz.tags.{ChatId, MessageId}
import shapeless.tag.@@


/**
  * This object represents a message.
  *
  * @param messageId             Unique message identifier
  * @param date                  Date the message was sent in Unix time
  * @param chat                  Conversation the message belongs to
  * @param from                  Sender, can be empty for messages sent to channels
  * @param forwardFrom           For forwarded messages, sender of the original message
  * @param forwardFromChat       For messages forwarded from a channel, information about the original channel
  * @param forwardDate           For forwarded messages, date the original message was sent in Unix time
  * @param replyToMessage        For replies, the original message. Note that the Message object in this
  *                              field will not contain further reply_to_message fields even if it itself is a reply.
  * @param text                  For text messages, the actual UTF-8 text of the message, 0-4096 characters.
  * @param entities              For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
  * @param audio                 Message is an audio file, information about the file
  * @param document              Message is a general file, information about the file
  * @param photo                 Message is a photo, available sizes of the photo
  * @param sticker               Message is a sticker, information about the sticker
  * @param video                 Message is a video, information about the video
  * @param voice                 Message is a voice message, information about the file
  * @param caption               Caption for the document, photo or video, 0-200 characters
  * @param contact               Message is a shared contact, information about the contact
  * @param location              Message is a shared location, information about the location
  * @param venue                 Message is a venue, information about the venue
  * @param newChatMember         A new member was added to the group, information about them (this member may be the bot itself)
  * @param leftChatMember        A member was removed from the group, information about them (this member may be the bot itself)
  * @param newChatTitle          A chat title was changed to this value
  * @param newChatPhoto          A chat photo was changed to this value
  * @param deleteChatPhoto       Service message: the chat photo was deleted
  * @param groupChatCreated      Service message: the group has been created
  * @param superGroupChatCreated Service message: the supergroup has been created
  * @param channelChatCreated    Service message: the channel has been created
  * @param migrateToChatId       The group has been migrated to a supergroup with the specified identifier, not exceeding 1e13 by absolute value
  * @param migrateFromChatId     The supergroup has been migrated from a group with the specified identifier, not exceeding 1e13 by absolute value
  * @param pinnedMessage         Specified message was pinned. Note that the Message object in this field
  *                              will not contain further reply_to_message fields even if it is itself a reply.
  */
case class Message(messageId: Int @@ MessageId,
                   date: Date,
                   chat: Chat,
                   from: Option[User] = None,
                   forwardFrom: Option[User] = None,
                   forwardFromChat: Option[Chat] = None,
                   forwardDate: Option[Date] = None,
                   replyToMessage: Option[Message] = None,
                   text: Option[String] = None,
                   entities: Option[Vector[MessageEntity]] = None,
                   audio: Option[Audio] = None,
                   document: Option[Document] = None,
                   photo: Option[Vector[PhotoSize]] = None,
                   sticker: Option[Sticker] = None,
                   video: Option[Video] = None,
                   voice: Option[Voice] = None,
                   caption: Option[String] = None,
                   contact: Option[Contact] = None,
                   location: Option[Location] = None,
                   venue: Option[Venue] = None,
                   newChatMember: Option[User] = None,
                   leftChatMember: Option[User] = None,
                   newChatTitle: Option[String] = None,
                   newChatPhoto: Option[Vector[PhotoSize]] = None,
                   deleteChatPhoto: Option[Boolean] = None,
                   groupChatCreated: Option[Boolean] = None,
                   superGroupChatCreated: Option[Boolean] = None,
                   channelChatCreated: Option[Boolean] = None,
                   migrateToChatId: Option[Int @@ ChatId] = None,
                   migrateFromChatId: Option[Int @@ ChatId] = None,
                   pinnedMessage: Option[Message] = None)
