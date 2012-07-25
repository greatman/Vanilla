/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.protocol.codec;

import java.io.IOException;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;
import org.spout.vanilla.protocol.ChannelBufferUtils;
import org.spout.vanilla.protocol.msg.LocalViewDistanceMessage;

public class LocaleViewDistanceCodec extends MessageCodec<LocalViewDistanceMessage> {
	public LocaleViewDistanceCodec() {
		super(LocalViewDistanceMessage.class, 0xCC);
	}

	@Override
	public LocalViewDistanceMessage decode(ChannelBuffer buffer) throws IOException {
		String locale = ChannelBufferUtils.readString(buffer);
		byte viewDistance = buffer.readByte();
		byte chatFlags = buffer.readByte();
		byte difficulty = buffer.readByte();
		return new LocalViewDistanceMessage(locale, viewDistance, chatFlags, difficulty);
	}

	@Override
	public ChannelBuffer encode(LocalViewDistanceMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
		ChannelBufferUtils.writeString(buffer, message.getLocale());
		buffer.writeByte(message.getViewDistance());
		buffer.writeInt(message.getChatFlags());
		buffer.writeByte(message.getDifficulty());
		return buffer;
	}
}
