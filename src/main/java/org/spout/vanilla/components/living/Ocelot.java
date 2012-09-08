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
package org.spout.vanilla.components.living;

import org.spout.vanilla.VanillaPlugin;
import org.spout.vanilla.data.VanillaData;
import org.spout.vanilla.protocol.entity.living.OcelotEntityProtocol;

/**
 * A component that identifies the entity as a Ocelot.
 */
public class Ocelot extends VanillaEntity {
	@Override
	public void onAttached() {
		super.onAttached();
		getHolder().getNetwork().setEntityProtocol(VanillaPlugin.VANILLA_PROTOCOL_ID, new OcelotEntityProtocol());
	}

	public boolean isTamed() {
		return getHolder().getData().get(VanillaData.TAMED);
	}

	public void setTamed(boolean tamed) {
		getHolder().getData().put(VanillaData.TAMED, tamed);
	}

	public String getOwner() {
		return getHolder().getData().get(VanillaData.OWNER);
	}

	public void setOwner(String owner) {
		if (isTamed()) {
			getHolder().getData().put(VanillaData.OWNER, owner);
		}
	}

	public byte getSkinId() {
		return getHolder().getData().get(VanillaData.SKIN);
	}

	public void setSkinId(byte skinId) {
		getHolder().getData().put(VanillaData.SKIN, skinId);
	}

	public boolean isSitting() {
		return getHolder().getData().get(VanillaData.SITTING);
	}

	public void setSitting(boolean sitting) {
		getHolder().getData().put(VanillaData.SITTING, sitting);
	}
}
