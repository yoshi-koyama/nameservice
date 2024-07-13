package com.example.nameservice.service;

import com.example.nameservice.Name;
import com.example.nameservice.mapper.NameMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NameServiceTest {

    // Mockito ってなに？
    // スタブ、モックってなに？

    @InjectMocks
    private NameService nameService;

    @Mock
    private NameMapper nameMapper;


    @Test
    public void 指定したIDの名前を取得できること() {
        // スタブの設定
        doReturn(Optional.of(new Name(1, "Bob"))).when(nameMapper).findById(1);

        // テスト対象のメソッドを実行
        Name actual = nameService.findName(1);

        // 実行結果を検証
        assertThat(actual).isEqualTo(new Name(1, "Bob"));

        // スタブの呼び出しを検証
        verify(nameMapper, times(1)).findById(1);
    }

    // 例外をthrowする場合の検証はどう書くのか？
    // assertThatThrownBy
    @Test
    public void 存在しないIDを指定した場合は例外が発生すること() {
    }

}
