package com.scm.entity;

import java.util.ArrayList;import org.hibernate.metamodel.ValueClassification;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User<UserBuilder> {
	@Id
	private String userId;
	@Column(name="user_name",nullable = false)
	private String name;
	@Column(unique = true,nullable = false)
	private String email;
	private String password;
	@Column(length = 1000)
	private String about;
	@Column(length = 1000)

	private String profilePic;
	private String phoneNumber;
	
	//information
	
	private boolean enabled=false;
	private boolean eamilVerified=false;
	private boolean phoneVerifies=false;
	
	
	@Enumerated(value = EnumType.STRING)
	//SELF,GOOGLE FB,GITHUB
	private Providers provider=Providers.SELF;
	private  String  providerUserId;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + ", profilePic=" + profilePic + ", phoneNumber=" + phoneNumber + ", enabled=" + enabled
				+ ", eamilVerified=" + eamilVerified + ", phoneVerifies=" + phoneVerifies + ", provider=" + provider
				+ ", providerUserId=" + providerUserId + ", contacts=" + contacts + "]";
	}

	//add more fields  if need
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	private List<Contact> contacts=new ArrayList<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEamilVerified() {
		return eamilVerified;
	}

	public void setEamilVerified(boolean eamilVerified) {
		this.eamilVerified = eamilVerified;
	}

	public boolean isPhoneVerifies() {
		return phoneVerifies;
	}

	public void setPhoneVerifies(boolean phoneVerifies) {
		this.phoneVerifies = phoneVerifies;
	}

	public Providers getProvider() {
		return provider;
	}

	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	public static class UserBuilder {
        private String userId;
        private String name;
        private String email;
        private String password;
        private String about;
        private String profilePic;
        private String phoneNumber;
        private boolean enabled = false;
        private boolean eamilVerified = false;
        private boolean phoneVerifies = false;
        private Providers provider = Providers.SELF;
        private String providerUserId;
        private List<Contact> contacts = new ArrayList<>();

        public UserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder about(String about) {
            this.about = about;
            return this;
        }

        public UserBuilder profilePic(String profilePic) {
            this.profilePic = profilePic;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public UserBuilder eamilVerified(boolean eamilVerified) {
            this.eamilVerified = eamilVerified;
            return this;
        }

        public UserBuilder phoneVerifies(boolean phoneVerifies) {
            this.phoneVerifies = phoneVerifies;
            return this;
        }

        public UserBuilder provider(Providers provider) {
            this.provider = provider;
            return this;
        }

        public UserBuilder providerUserId(String providerUserId) {
            this.providerUserId = providerUserId;
            return this;
        }

        public UserBuilder contacts(List<Contact> contacts) {
            this.contacts = contacts;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUserId(this.userId);
            user.setName(this.name);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setAbout(this.about);
            user.setProfilePic(this.profilePic);
            user.setPhoneNumber(this.phoneNumber);
            user.setEnabled(this.enabled);
            user.setEamilVerified(this.eamilVerified);
            user.setPhoneVerifies(this.phoneVerifies);
            user.setProvider(this.provider);
            user.setProviderUserId(this.providerUserId);
            user.setContacts(this.contacts);
            return user;
        }
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }
   

	}

	

	
	
	
	

