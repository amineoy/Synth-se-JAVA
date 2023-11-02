package net.ziad.busness;

import net.ziad.model.BanqueAccount;
@FunctionalInterface // Pour marquer une methode fonctionnell contient plus d'un methode
public interface Condition<T> {

    public boolean test(T o);
}
