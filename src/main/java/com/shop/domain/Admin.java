package com.shop.domain;

public class Admin {
    private String username;
    private String password;
    private String email;
    private int level;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;

        Admin admin = (Admin) o;

        if (getLevel() != admin.getLevel()) return false;
        if (!getUsername().equals(admin.getUsername())) return false;
        if (!getPassword().equals(admin.getPassword())) return false;
        return getEmail().equals(admin.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getLevel();
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                '}';
    }
}
