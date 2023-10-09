package eu.eugene.training.retailchain.service.batchService;

import eu.eugene.training.retailchain.entity.Batch;
import eu.eugene.training.retailchain.exception.InvalidDayBeforeExpirationDateException;
import eu.eugene.training.retailchain.exception.RemainingQuantityNegativeCountException;
import eu.eugene.training.retailchain.exception.ZeroRemainingItemsInBatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BatchServiceImplTest {

    private BatchServiceImpl classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new BatchServiceImpl();
    }

    @Test
    public void should_returnTrue_when_remainingTimeIsLessThanTotalTimeDividedByTwo() {
        // Given
        Batch batch = new Batch();
        batch.setDeliveryDate(LocalDate.now().minusDays(10));
        batch.setExpirationDate(LocalDate.now().plusDays(5));

        // When
        boolean result = classUnderTest.hasHalfExpirationTimePassed(batch);

        // Then
        assertTrue(result);
    }

    @Test
    public void should_throwException_when_remainingItemsAreMoreThanHalfOfTheReceived() {
        // Given
        Batch batch = new Batch();
        batch.setQuantity(100);
        batch.setQuantityStatus(60);

        // When
        boolean result = classUnderTest.isOverstockedItems(batch);

        // Then
        assertTrue(result);
    }

    @Test
    public void should_throwException_when_remainingQuantityIsZero() {
        //Given
        Batch batch = new Batch();
        batch.setQuantity(100);
        batch.setQuantityStatus(0);

        // When
        Executable thrown = () -> classUnderTest.isOverstockedItems(batch);

        // Then
        Exception remainingQuantityZeroException = assertThrows(ZeroRemainingItemsInBatchException.class, thrown);
        assertEquals("Remaining items in batch are zero.", remainingQuantityZeroException.getMessage());
    }

    @Test
    public void should_throwException_when_getHalfOfTheTotalQuantityItemsForBatch_invalid() {
        // Given
        Batch batch = new Batch();
        batch.setQuantity(-100);
        batch.setQuantityStatus(30);

        // When
        Executable thrown = () -> classUnderTest.isOverstockedItems(batch);

        // Then
        Exception remainingItemsAreLessThanHalfOfTheReceived = assertThrows(RemainingQuantityNegativeCountException.class, thrown);
        assertEquals("Remaining quantity of item is negative count.", remainingItemsAreLessThanHalfOfTheReceived.getMessage());
    }

    @Test
    public void should_throwException_when_remainingQuantityForBatch_is_zero() {
        // Given
        Batch batch = new Batch();
        batch.setQuantityStatus(0);

        // When
        Executable thrown = () -> classUnderTest.isOverstockedItems(batch);

        // Then
        Exception remainingItemsAreLessThanHalfOfTheReceived = assertThrows(ZeroRemainingItemsInBatchException.class, thrown);
        assertEquals("Remaining items in batch are zero.", remainingItemsAreLessThanHalfOfTheReceived.getMessage());
    }

    @Test
    public void should_returnTrue_when_todayIsExactlySeventhDayBeforeExpirationDate() {
        // Given
        Batch batch = new Batch();
        batch.setExpirationDate(LocalDate.now());
        LocalDate expirationDateSevenDaysBefore = batch.getExpirationDate().plusDays(7);
        batch.setExpirationDate(expirationDateSevenDaysBefore);

        // When
        boolean isTodaySevenDaysBefore = classUnderTest.isBatchExpiringIn(batch, 7);

        // Then
        assertTrue(isTodaySevenDaysBefore);
    }

    @Test
    public void should_returnTrue_when_todayIsExactlySecondDayBeforeExpirationDate() {
        // Given
        Batch batch = new Batch();
        batch.setExpirationDate(LocalDate.now());
        LocalDate expirationDateTwoDaysBefore = batch.getExpirationDate().plusDays(2);
        batch.setExpirationDate(expirationDateTwoDaysBefore);

        // When
        boolean isTodayTwoDaysBefore = classUnderTest.isBatchExpiringIn(batch, 2);

        // Then
        assertTrue(isTodayTwoDaysBefore);
    }

    @Test
    public void should_returnFalse_when_todayIsNotSeventhDayBeforeExpirationDate() {
        // Given
        Batch batch = new Batch();
        batch.setExpirationDate(LocalDate.now());
        LocalDate expirationDateTwoDaysBefore = batch.getExpirationDate().plusDays(10);
        batch.setExpirationDate(expirationDateTwoDaysBefore);

        // When
        boolean isTodaySevenDaysBefore = classUnderTest.isBatchExpiringIn(batch, 7);

        //Then
        assertFalse(isTodaySevenDaysBefore);
    }

    @Test
    public void should_returnFalse_when_todayIsNotSecondDayBeforeExpirationDate() {
        // Given
        Batch batch = new Batch();
        batch.setExpirationDate(LocalDate.now().minusDays(10));

        // When
        boolean result = classUnderTest.isBatchExpiringIn(batch, 2);

        // Then
        assertFalse(result);
    }

    @Test
    public void should_throwException_when_todayIsNotSeventhOrSecondDayBeforeExpirationDate() {
        // Given
        Batch batch = new Batch();
        batch.setExpirationDate(LocalDate.now());
        LocalDate expirationDateTwoDaysBefore = batch.getExpirationDate().plusDays(10);
        batch.setExpirationDate(expirationDateTwoDaysBefore);

        // When
        Executable thrown = () -> classUnderTest.isBatchExpiringIn(batch, -10);

        // Then
        Exception invalidNumberCountException = assertThrows(InvalidDayBeforeExpirationDateException.class, thrown);
        assertEquals("Invalid number of days before expiration date.", invalidNumberCountException.getMessage());
    }

    @Test
    public void should_throwException_when_todayIsZeroDaysBeforeExpirationDate() {
        // Given
        Batch batch = new Batch();
        batch.setExpirationDate(LocalDate.now());
        LocalDate expirationDateDaysBefore = batch.getExpirationDate().plusDays(10);
        batch.setExpirationDate(expirationDateDaysBefore);

        // When
        Executable thrown = () -> classUnderTest.isBatchExpiringIn(batch, 0);

        // Then
        Exception invalidNumberCountException = assertThrows(InvalidDayBeforeExpirationDateException.class, thrown);
        assertEquals("Invalid number of days before expiration date.", invalidNumberCountException.getMessage());
    }

    @Test
    public void should_throwException_when_remainingItemsInBatchAreNone() {
        // Given
        Batch batch = new Batch();
        batch.setQuantity(100);
        batch.setQuantityStatus(0);

        // When
        Executable thrown = () -> classUnderTest.hasRemainingItems(batch);

        // Then
        Exception remainingItemsAreLessThenHalfOfTheReceived = assertThrows(ZeroRemainingItemsInBatchException.class, thrown);
        assertEquals("Remaining items in batch are zero.", remainingItemsAreLessThenHalfOfTheReceived.getMessage());
    }

    @Test
    public void should_returnTrue_when_remainingItemInBatchIsExactlyOne() {
        // Given
        Batch batch = new Batch();
        batch.setQuantity(100);
        batch.setQuantityStatus(1);

        // Then
        assertTrue(classUnderTest.hasRemainingItems(batch));
    }

    @Test
    public void should_returnTrue_when_remainingItemInBatchIsMoreThanOne() {
        // Given
        Batch batch = new Batch();
        batch.setQuantity(100);
        batch.setQuantityStatus(10);

        // Then
        assertTrue(classUnderTest.hasRemainingItems(batch));
    }
}