package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractPagingResponse {

    @Expose
    @SerializedName("total_count")
    private int totalCount;

    @Expose
    @SerializedName("search_criteria")
    private SearchCriteriaResponse searchCriteria;

    public SearchCriteriaResponse getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteriaResponse searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private static class SearchCriteriaResponse {

        @Expose
        @SerializedName("page_size")
        private int pageSize;

        @Expose
        @SerializedName("current_page")
        private int currentPage;

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }
    }
}
