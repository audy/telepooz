package com.github.nikdon.model

import java.time.Duration

import com.github.nikdon.tags.FileId
import com.github.nikdon.{ToDTO, dto}
import shapeless.tag.@@


/**
  * This object represents a voice note.
  *
  * @param fileId   Unique identifier for this file
  * @param duration Duration of the audio in seconds as defined by sender
  * @param mimeType MIME type of the file as defined by sender
  * @param fileSize File size
  */
case class Voice(fileId: String @@ FileId,
                 duration: Duration,
                 mimeType: String,
                 fileSize: Int)

object Voice {
  implicit val toDTO: ToDTO[Voice, dto.Voice] =
    ToDTO(v ⇒ dto.Voice(v.fileId, v.duration.getSeconds.toInt, v.mimeType, v.fileSize))
}