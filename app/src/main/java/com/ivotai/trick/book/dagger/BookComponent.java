package com.ivotai.trick.book.dagger;

import com.ivotai.trick.app.AppComponent;
import com.ivotai.trick.book.view.BookActivity;

import dagger.Component;

/**
 * The interface Book component.
 * Book层级依赖注入器
 * 可注入依赖：AppComponent所暴露的方法以及BookModule提供的
 */
@BookScope
@Component(dependencies = AppComponent.class, modules = BookModule.class)
public interface BookComponent {

    /**
     * Inject.
     *
     * @param o the o
     */
     void inject(BookActivity o);

}
