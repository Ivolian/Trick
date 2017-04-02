package com.ivotai.trick.book;

import com.ivotai.trick.BookScope;
import com.ivotai.trick.app.AppComponent;

import dagger.Component;

/**
 * The interface Book component.
 */
@BookScope
@Component(dependencies = AppComponent.class, modules = BookModule.class)
interface BookComponent {

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(BookActivity o);

}
