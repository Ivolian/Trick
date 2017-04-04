package com.ivotai.trick.book.dagger;

import com.ivotai.trick.book.view.BookFragment;
import com.ivotai.trick.main.dagger.MainComponent;

import dagger.Component;

/**
 * The interface Book component.
 * Book的依赖注入器
 * 可注入依赖：AppComponent所暴露的方法以及BookModule提供的部分
 */
@BookScope
//@Subcomponent(modules = {BookModule.class, MainModule.class})
@Component(dependencies = MainComponent.class, modules = BookModule.class)
public interface BookComponent {

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(BookFragment o);

}
