package order_system.item.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.CategoryType;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;
import order_system.item.mapper.dto.ItemSaveRequestDto;
import order_system.item.mapper.dto.ItemUpdateRequestDto;
import order_system.item.repository.ItemRepository;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.mapper.dto.SignupRequestDto;
import order_system.member.repository.MemberRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AcceptanceTest
class ItemRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("로그인을 하지 않으면 상품을 저장할 수 없습니다")
    void saveFail() throws Exception {
        // given
        ItemSaveRequestDto dto = ItemSaveRequestDto.builder()
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .build();

        // expected
        mockMvc.perform(post("/api/item")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("로그인 후 상품을 저장할 수 있습니다")
    void saveSuccess() throws Exception {
        // given
        ItemSaveRequestDto dto = ItemSaveRequestDto.builder()
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .build();

        signup();
        MockHttpSession session = loginMemberSession();

        // expected
        mockMvc.perform(post("/api/item")
                        .session(session)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인을 하지 않으면 상품을 수정할 수 없습니다")
    void updateFail() throws Exception {
        // given
        ItemJpaEntity entity = saveItem();

        ItemUpdateRequestDto dto = ItemUpdateRequestDto.builder()
                .itemId(entity.getId())
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .build();

        // expected
        mockMvc.perform(patch("/api/item")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("로그인 후 상품을 수정할 수 있습니다")
    void updateSuccess() throws Exception {
        // given
        ItemJpaEntity entity = saveItem();

        ItemUpdateRequestDto dto = ItemUpdateRequestDto.builder()
                .itemId(entity.getId())
                .itemName("수정 상품 이름")
                .itemPrice(100000)
                .stockQuantity(5000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .categoryType(CategoryType.SHOES)
                .build();

        signup();
        MockHttpSession session = loginMemberSession();

        // expected
        mockMvc.perform(patch("/api/item")
                        .session(session)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    protected void signup() {
        MemberJpaEntity entity = MemberJpaEntity.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        memberRepository.save(entity);
    }

    protected MockHttpSession loginMemberSession() throws Exception {
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        MockHttpServletRequest request = mockMvc.perform(post("/api/login")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andReturn().getRequest();

        HttpSession session = request.getSession();
        return (MockHttpSession)session;
    }

    protected ItemJpaEntity saveItem() {
        ItemJpaEntity entity = ItemJpaEntity.builder()
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .categoryType(CategoryType.SHOES)
                .build();

        itemRepository.save(entity);
        return entity;
    }
}